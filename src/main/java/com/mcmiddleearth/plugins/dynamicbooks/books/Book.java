package com.mcmiddleearth.plugins.dynamicbooks.books;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Collections;
import java.util.List;

import static com.mcmiddleearth.plugins.dynamicbooks.DynamicBooksPlugin.BOOK_PREFIX;

public class Book {

    private final String bookId;
    private final ItemStack mcItem;

    public static String getIngameBookName(String bookId) {
        return String.format("%s '%s'", BOOK_PREFIX, bookId);
    }

    public Book(String bookId, String author, List<BaseComponent[]> pages) {
        this.bookId = bookId;
        this.mcItem = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta metaData = (BookMeta) mcItem.getItemMeta();
        metaData.setAuthor(author);
        metaData.setTitle(String.format("Book of %s", bookId));
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
}
