package com.mcmiddleearth.plugins.dynamicbooks.books;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.mcmiddleearth.plugins.dynamicbooks.DynamicBooksPlugin.BOOK_PREFIX;

public class Book {

    public enum Permission {
        GIVE("library.give.*"),
        GIVE_REMOTE("library.giveremote.*"),
        OPEN("library.open.*"),
        OPEN_REMOTE("library.openremote.*");

        String bypassPermission;

        Permission(String bypassPermission) {
            this.bypassPermission = bypassPermission;
        }

        public String getBypassPermission() {
            return bypassPermission;
        }
    }

    private final String bookId;
    private final String title;
    private final ItemStack mcItem;
    private Map<Permission, String> permissions;

    public static String getIngameBookName(String bookId) {
        return String.format("%s '%s'", BOOK_PREFIX, bookId);
    }

    public Book(String bookId, String author, Map<Permission, String> permissions, List<BaseComponent[]> pages) {
        this.bookId = bookId;
        this.mcItem = new ItemStack(Material.WRITTEN_BOOK);
        this.permissions = permissions;
        title = String.format("Book of %s", bookId);

        BookMeta metaData = (BookMeta) mcItem.getItemMeta();
        metaData.setAuthor(author);
        metaData.setTitle(title);
        metaData.setLore(Collections.singletonList(getIngameBookName(bookId)));

        for (BaseComponent[] page : pages) {
            metaData.spigot().addPage(page);
        }

        mcItem.setItemMeta(metaData);
    }

    public String getBookId() {
        return bookId;
    }

    public ItemStack getItem() {
        return mcItem;
    }

    public String getPermission(Permission permission) {
        return permissions.getOrDefault(permission, null);
    }
}
