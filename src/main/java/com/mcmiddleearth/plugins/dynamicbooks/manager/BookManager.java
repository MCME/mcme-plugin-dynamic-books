package com.mcmiddleearth.plugins.dynamicbooks.manager;

import com.mcmiddleearth.plugins.dynamicbooks.library.BookLibrary;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class BookManager {

    private final BookLibrary bookLibrary;

    public BookManager(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public void giveBook(Player source, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }
        ItemStack itemBook = bookLibrary.getBook(book);
        for (Map.Entry<Integer, ? extends ItemStack> item : source.getInventory().all(Material.WRITTEN_BOOK).entrySet()) {
            if (item.getValue() != null && item.getValue().getItemMeta() != null && item.getValue().getItemMeta().getLore() != null) {
                if (item.getValue().getItemMeta().getLore().contains(bookLibrary.getIngameBookName(book))) {
                    source.getInventory().setItem(item.getKey(), itemBook);
                    return;
                }
            }
        }
        source.getInventory().addItem(itemBook);

    }

    public void openBook(Player source, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        source.openBook(bookLibrary.getBook(book));
    }
}
