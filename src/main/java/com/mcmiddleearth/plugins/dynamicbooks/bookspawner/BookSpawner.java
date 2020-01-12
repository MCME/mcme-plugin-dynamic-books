package com.mcmiddleearth.plugins.dynamicbooks.bookspawner;

import com.mcmiddleearth.plugins.dynamicbooks.BookManager;
import com.mcmiddleearth.plugins.dynamicbooks.books.Book;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookSpawner {

    public void spawnBook(Player player, Set<Book> books) {
        List<ItemStack> collect = books.stream().map(Book::asItemStack).collect(Collectors.toList());
        player.getInventory().addItem(collect.toArray(new ItemStack[]{}));
    }

    public void spawnAllBooks(Player player) {
        Set<Book> books = BookManager.getAllBooks();
        spawnBook(player,books);
    }
}
