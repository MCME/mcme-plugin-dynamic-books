package com.mcmiddleearth.plugins.dynamicbooks.manager;

import com.mcmiddleearth.plugins.dynamicbooks.DynamicBooksPlugin;
import com.mcmiddleearth.plugins.dynamicbooks.books.Book;
import com.mcmiddleearth.plugins.dynamicbooks.library.BookLibrary;
import com.mcmiddleearth.plugins.dynamicbooks.library.LibraryBookChangedListener;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.mcmiddleearth.plugins.dynamicbooks.books.Book.Permission.*;

public class BookManager {

    private final BookLibrary bookLibrary;

    public BookManager(BookLibrary bookLibrary, Server server) {
        this.bookLibrary = bookLibrary;

        bookLibrary.addListener(bookId -> {
            Logger.getGlobal().info("Notified for delete " + bookId);
            for (Player onlinePlayer : server.getOnlinePlayers()) {
                removeBookForPlayer(bookId, onlinePlayer);
            }
        });
    }

    public void refreshPlayerBook(Player player, ItemStack itemStack) {
        if (!itemStack.getType().equals(Material.WRITTEN_BOOK)) {
            return;
        }

        if (itemStack.getItemMeta() != null && itemStack.getItemMeta().getLore() != null) {
            Set<String> collect = itemStack.getItemMeta().getLore().stream().filter(lore -> lore.startsWith(DynamicBooksPlugin.BOOK_PREFIX)).collect(Collectors.toSet());

            if (collect.size() == 0) {
                return;
            }

            int inventoryPosition = player.getInventory().first(itemStack);
            player.getInventory().remove(itemStack);

            for (String bookString : collect) {
                if (bookLibrary.verifyAccessByIngameName(bookString, player, GIVE)) {
                    player.getInventory().setItem(inventoryPosition, bookLibrary.getBookByInGameName(bookString));
                    return;
                }
            }
        }
    }

    private void removeBookForPlayer(String bookId, Player onlinePlayer) {
        HashMap<Integer, ? extends ItemStack> all = onlinePlayer.getInventory().all(Material.WRITTEN_BOOK);

        for (Map.Entry<Integer, ? extends ItemStack> bookEntry : all.entrySet()) {
            if (bookEntry.getValue().getItemMeta() != null && bookEntry.getValue().getItemMeta().getLore() != null) {
                if (bookEntry.getValue().getItemMeta().getLore().contains(Book.getIngameBookName(bookId))) {
                    onlinePlayer.getInventory().remove(bookEntry.getValue());
                }
            }
        }
    }

    public void giveRemoteBook(Player source, Player target, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if (bookLibrary.verifyAccess(book, source, GIVE_REMOTE)) {
            giveBook(target, book);
        }
    }

    public void giveBook(Player source, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if (bookLibrary.verifyAccess(book, source, GIVE)) {
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
    }

    public void openRemoteBook(Player source, Player target, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if (bookLibrary.verifyAccess(book, source, OPEN_REMOTE)) {
            openBook(target, book);
        }
    }
    public void openBook(Player source, String book) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if (bookLibrary.verifyAccess(book, source, OPEN)) {
            source.openBook(bookLibrary.getBook(book));
        }
    }

}
