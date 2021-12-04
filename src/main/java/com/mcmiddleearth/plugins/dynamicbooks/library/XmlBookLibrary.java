package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.DynamicBooksPlugin;
import com.mcmiddleearth.plugins.dynamicbooks.books.Book;
import com.mcmiddleearth.plugins.dynamicbooks.books.BookBuilder;
import com.mcmiddleearth.plugins.dynamicbooks.jaxb.XmlBook;
import com.mcmiddleearth.plugins.dynamicbooks.jaxb.XmlTemplate;
import jakarta.xml.bind.JAXBElement;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.ChatColor;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class XmlBookLibrary extends BookLibrary {

    @Override
    final protected void refresh(Set<String> currentBooks, ZonedDateTime lastUpdate) {
        List<XmlBook> xmlBooks = fetchXmlBooks(lastUpdate);

        for (XmlBook xmlBook : xmlBooks) {
            try {
                Map<String, XmlTemplate> templateReferences = generateTemplateReferences(xmlBook);
                Map<String, Integer> pageReferences = generatePageReferences(xmlBook);

                if (xmlBook.getId() == null) {
                    throw new BookParsingException(null, xmlBook.toString());
                }
                if (xmlBook.getAuthor() == null) {
                    throw new BookParsingException(xmlBook.getId(), "'Author' missing from <book>-tag.");
                }
                if (xmlBook.getPage() == null) {
                    throw new BookParsingException(xmlBook.getId(), "No pages defined for the book.");
                }

                BookBuilder bookBuilder = new BookBuilder(xmlBook.getId(), xmlBook.getAuthor());

                if (xmlBook.getPermissions() != null) {
                    if (xmlBook.getPermissions().getGive() != null) {
                        bookBuilder.withPermission(Book.Permission.GIVE, xmlBook.getPermissions().getGive());
                    }
                    if (xmlBook.getPermissions().getOpen() != null) {
                        bookBuilder.withPermission(Book.Permission.OPEN, xmlBook.getPermissions().getOpen());
                    }
                    if (xmlBook.getPermissions().getGiveremote() != null) {
                        bookBuilder.withPermission(Book.Permission.GIVE_REMOTE, xmlBook.getPermissions().getGiveremote());
                    }
                    if (xmlBook.getPermissions().getOpenremote() != null) {
                        bookBuilder.withPermission(Book.Permission.OPEN_REMOTE, xmlBook.getPermissions().getOpenremote());
                    }
                }

                for (XmlBook.XmlPage page : xmlBook.getPage()) {
                    List<BaseComponent[]> baseComponents = new ArrayList<>();

                    for (XmlBook.XmlPage.XmlLine line : page.getLine()) {
                        if (page.getLine().indexOf(line) != 0) {
                            baseComponents.add(newLine());
                        }
                        for (Serializable serializable : line.getContent()) {
                            baseComponents.add(parseSerializableSection(serializable, pageReferences, templateReferences));
                        }
                    }
                    bookBuilder.withPage(baseComponents.stream().flatMap(Stream::of).collect(Collectors.toList()).toArray(new BaseComponent[]{}));
                }

                if (currentBooks.remove(xmlBook.getId())) {
                    updateBook(xmlBook.getId(),bookBuilder.build());
                } else {
                    addBook(bookBuilder.build());
                }
            } catch (BookParsingException exception) {
                Logger.getGlobal().log(Level.WARNING, exception.getMessage());
            } catch (PageParsingException exception) {
                Logger.getGlobal().log(Level.WARNING, String.format("Could not parse pages in book %s: %s", xmlBook.getId(), exception.getMessage()));
            }
        }

        currentBooks.forEach(super::removeBook);
    }

    private BaseComponent[] newLine() {
        return new ComponentBuilder("\n").create();
    }

    private BaseComponent[] parseSerializableSection(Serializable serializable, Map<String, Integer> pageReferences, Map<String, XmlTemplate> templateReferences) throws PageParsingException {
        if (serializable instanceof String) {
            return parseStringSection((String) serializable);
        } else if (serializable instanceof JAXBElement) {
            JAXBElement element = (JAXBElement) serializable;
            if (element.getName().toString().equals("obj")) {
                return parseObjSection((XmlBook.XmlPage.XmlLine.XmlObj) element.getValue(), pageReferences);
            } else if (element.getName().toString().equals("tpl")) {
                return parseTplSection((XmlBook.XmlPage.XmlLine.XmlTpl) element.getValue(), pageReferences, templateReferences);
            }
        }
        return new BaseComponent[]{};
    }

    private BaseComponent[] parseTplSection(XmlBook.XmlPage.XmlLine.XmlTpl tpl, Map<String, Integer> pageReferences, Map<String, XmlTemplate> templateReferences) throws PageParsingException {
        XmlTemplate.XmlOptions template = getTemplateReference(templateReferences, tpl.getRef()).getOptions();
        XmlBook.XmlPage.XmlLine.XmlObj obj = new XmlBook.XmlPage.XmlLine.XmlObj();

        obj.setAutoType(templateVariable(template.getAutoType(), tpl.getAutoType(), tpl));
        obj.setColor(templateVariable(template.getColor(), tpl.getColor(), tpl));
        obj.setExecute(templateVariable(template.getExecute(), tpl.getExecute(), tpl));
        obj.setGiveBook(templateVariable(template.getGiveBook(), tpl.getGiveBook(), tpl));
        obj.setHoverText(templateVariable(template.getHoverText(), tpl.getHoverText(), tpl));
        obj.setOpenBook(templateVariable(template.getOpenBook(), tpl.getOpenBook(), tpl));
        obj.setPage(templateVariable(template.getPage(), tpl.getPage(), tpl));
        obj.setStyles(templateVariable(template.getStyles(), tpl.getStyles(), tpl));
        obj.setUrl(templateVariable(template.getUrl(), tpl.getUrl(), tpl));
        obj.setValue(tpl.getValue());

        return parseObjSection(obj, pageReferences);
    }

    private String templateVariable(String templateContent, String objectContent, XmlBook.XmlPage.XmlLine.XmlTpl arguments) {
        if (objectContent != null) {
            return objectContent;
        }
        if (templateContent != null) {
            if (arguments.getArg1() != null) {
                templateContent = templateContent.replace("$1", arguments.getArg1());
            }
            if (arguments.getArg2() != null) {
                templateContent = templateContent.replace("$2", arguments.getArg2());
            }
            if (arguments.getArg3() != null) {
                templateContent = templateContent.replace("$3", arguments.getArg3());
            }
            if (arguments.getArg4() != null) {
                templateContent = templateContent.replace("$4", arguments.getArg4());
            }
            if (arguments.getArg5() != null) {
                templateContent = templateContent.replace("$5", arguments.getArg5());
            }
            return templateContent;
        }
        return null;
    }

    private BaseComponent[] parseObjSection(XmlBook.XmlPage.XmlLine.XmlObj obj, Map<String, Integer> pageReferences) throws PageParsingException {
        if (obj.getPage() != null) {
            obj.setValue(obj.getValue().replace("$page", String.valueOf(getPageReference(pageReferences, obj.getPage()))));
        }

        ComponentBuilder componentBuilder = new ComponentBuilder(obj.getValue());
        if (obj.getPage() != null) {
            Integer pageNumber = getPageReference(pageReferences, obj.getPage());
            componentBuilder.event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, String.valueOf(pageNumber)));
        }
        if (obj.getExecute() != null) {
            componentBuilder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.format("/%s", obj.getExecute())));
        }
        if (obj.getAutoType() != null) {
            componentBuilder.event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, obj.getAutoType()));
        }
        if (obj.getHoverText() != null) {
            componentBuilder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(obj.getHoverText()).create()));
        }
        if (obj.getOpenBook() != null) {
            componentBuilder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.format("/%s %s", DynamicBooksPlugin.OPEN_COMMAND, obj.getOpenBook())));
        }
        if (obj.getGiveBook() != null) {
            componentBuilder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.format("/%s %s", DynamicBooksPlugin.GIVE_COMMAND, obj.getOpenBook())));
        }
        if (obj.getUrl() != null) {
            componentBuilder.event(new ClickEvent(ClickEvent.Action.OPEN_URL, obj.getUrl()));
        }
        if (obj.getColor() != null) {
            try {
                componentBuilder.color(ChatColor.valueOf(obj.getColor().toUpperCase()).asBungee());
            } catch (IllegalArgumentException | NullPointerException exception) {
                throw new PageParsingException(String.format("unknown color '%s' used.",obj.getColor()));
            }
        }
        if (obj.getStyles() != null) {
            for (String style : obj.getStyles().toUpperCase().split(",")) {
                switch (style) {
                    case "BOLD":
                        componentBuilder.bold(true);
                        break;
                    case "UNDERLINED":
                        componentBuilder.underlined(true);
                        break;
                    case "ITALIC":
                        componentBuilder.italic(true);
                        break;
                    case "STRIKETHROUGH":
                        componentBuilder.strikethrough(true);
                        break;
                }
            }
        }

        return componentBuilder.create();
    }

    private XmlTemplate getTemplateReference(Map<String, XmlTemplate> templateReference, String page) throws PageParsingException {
        if (page == null) {
            throw new PageParsingException("Cannot use <tpl> without 'ref' attribute page");
        }

        if (!templateReference.containsKey(page)) {
            throw new PageParsingException("Unknown template reference found: " + page);
        }
        return templateReference.get(page);
    }

    private Integer getPageReference(Map<String, Integer> pageReferences, String page) throws PageParsingException {
        if (page == null || !pageReferences.containsKey(page)) {
            throw new PageParsingException("Unknown page reference found: " + page);
        }
        return pageReferences.get(page);
    }

    private BaseComponent[] parseStringSection(String text) {
        return new ComponentBuilder(text).create();
    }

    private Map<String, Integer> generatePageReferences(XmlBook xmlBook) {
        Map<String, Integer> pageReferences = new HashMap<>();
        if (xmlBook.getPage() != null) {
            for (XmlBook.XmlPage page : xmlBook.getPage()) {
                pageReferences.put(page.getRef(), pageReferences.size() + 1);
            }
        }
        return pageReferences;
    }

    private Map<String, XmlTemplate> generateTemplateReferences(XmlBook xmlBook) {
        Map<String, XmlTemplate> templateReferences = new HashMap<>();
        if (xmlBook.getTemplates() != null && xmlBook.getTemplates().getTemplate() != null) {
            for (XmlTemplate template : xmlBook.getTemplates().getTemplate()) {
                templateReferences.put(template.getName(), template);
            }
        }
        return templateReferences;
    }

    abstract public List<XmlBook> fetchXmlBooks(ZonedDateTime lastUpdate);
}
