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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mcmiddleearth.plugins.dynamicbooks.books.Book.Permission.*;

public class BookManager {

    private final BookLibrary bookLibrary;

    public BookManager(BookLibrary bookLibrary, Server server) {
        this.bookLibrary = bookLibrary;

        bookLibrary.addListener((LibraryBookChangedListener) (bookId, book) -> {
            Logger.getGlobal().info("Notified for change " + bookId);
            for (Player onlinePlayer : server.getOnlinePlayers()) {
                refreshBookForPlayer(bookId, onlinePlayer);
            }
        });
        bookLibrary.addListener(bookId -> {
            Logger.getGlobal().info("Notified for delete " + bookId);
            for (Player onlinePlayer : server.getOnlinePlayers()) {
                removeBookForPlayer(bookId, onlinePlayer);
            }
        });
    }

    public void refreshPlayerAndRemoveFaultyBooks(Player player) {
        HashMap<Integer, ? extends ItemStack> all = player.getInventory().all(Material.WRITTEN_BOOK);

        for (Map.Entry<Integer, ? extends ItemStack> bookEntry : all.entrySet()) {
            if (bookEntry.getValue().getItemMeta() != null && bookEntry.getValue().getItemMeta().getLore() != null) {
                Set<String> collect = bookEntry.getValue().getItemMeta().getLore().stream().filter(lore -> lore.startsWith(DynamicBooksPlugin.BOOK_PREFIX)).collect(Collectors.toSet());

                boolean found = false;
                for (String bookString : collect) {
                    String bookIdFromIngameName = bookLibrary.getBookIdFromIngameName(bookString);
                    if (bookIdFromIngameName != null) {
                        found = true;
                        if (bookLibrary.verifyAccess(bookIdFromIngameName, player, GIVE)) {
                            player.getInventory().setItem(bookEntry.getKey(), bookLibrary.getBook(bookIdFromIngameName));
                        } else {
                            player.getInventory().remove(bookEntry.getValue());
                        }
                    }
                }
                if (!found) {
                    player.getInventory().remove(bookEntry.getValue());
                }
            }
        }
        for (String bookId : bookLibrary.getAllBookIds()) {
            refreshBookForPlayer(bookId, player);
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

    private void refreshBookForPlayer(String bookId, Player onlinePlayer) {
        HashMap<Integer, ? extends ItemStack> all = onlinePlayer.getInventory().all(Material.WRITTEN_BOOK);
        ItemStack book = bookLibrary.getBook(bookId);

        if (book == null) {
            return;
        }

        for (Map.Entry<Integer, ? extends ItemStack> bookEntry : all.entrySet()) {
            if (bookEntry.getValue().getItemMeta() != null && bookEntry.getValue().getItemMeta().getLore() != null) {
                if (bookEntry.getValue().getItemMeta().getLore().contains(Book.getIngameBookName(bookId))) {
                    if (bookLibrary.verifyAccess(bookId, onlinePlayer, GIVE)) {
                        onlinePlayer.getInventory().setItem(bookEntry.getKey(), book);
                    } else {
                        onlinePlayer.getInventory().remove(bookEntry.getValue());
                    }
                }
            }
        }
    }

    public void giveBook(Player source, String book, boolean remote) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if (bookLibrary.verifyAccess(book,source, remote ? GIVE_REMOTE : GIVE)) {
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

    public void openBook(Player source, String book, boolean remote) {
        if (source == null || !bookLibrary.exists(book)) {
            return;
        }

        if(bookLibrary.verifyAccess(book,source, remote ? OPEN_REMOTE : OPEN)) {
            source.openBook(bookLibrary.getBook(book));
        }
    }
}
