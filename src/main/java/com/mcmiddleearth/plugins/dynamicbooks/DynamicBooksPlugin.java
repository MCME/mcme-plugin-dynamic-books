package com.mcmiddleearth.plugins.dynamicbooks;

import com.google.common.base.Joiner;
import com.mcmiddleearth.plugins.dynamicbooks.command.BookCommand;
import com.mcmiddleearth.plugins.dynamicbooks.library.*;
import com.mcmiddleearth.plugins.dynamicbooks.listener.BookUseListener;
import com.mcmiddleearth.plugins.dynamicbooks.manager.BookManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public final class DynamicBooksPlugin extends JavaPlugin {

    public static final String OPEN_COMMAND = "library open";
    public static final String GIVE_COMMAND = "library give";
    public static final String BOOK_PREFIX = "Ancient Book";

    private BookManager bookManager;
    private BookLibrary bookLibrary;
    private CommandDispatcher<Player> commandDispatcher;
    private BookUseListener bookUseListener;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Plugin startup logic
        bookLibrary = new OfflineBookLibrary(getDataFolder());
        bookManager = new BookManager(bookLibrary, getServer());

        bookUseListener = new BookUseListener(bookManager);

        // Check permissions based on spigot
        bookLibrary.start(getConfig().getInt("refresh.interval", 900));

        getServer().getPluginManager().registerEvents(bookUseListener,this);
        this.commandDispatcher = new BookCommand(this, bookLibrary, bookManager);


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            try {
                if (args.length > 0) {
                    commandDispatcher.execute(commandDispatcher.parse(String.format("%s %s", label, Joiner.on(" ").join(args)), (Player) sender));
                } else {
                    commandDispatcher.execute(commandDispatcher.parse(label, (Player) sender));
                }
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            try {
                CompletableFuture<Suggestions> completionSuggestions = commandDispatcher.getCompletionSuggestions(commandDispatcher.parse(getInput(command, args), (Player) sender));
                return completionSuggestions.get().getList().stream().map(Suggestion::getText).collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private String getInput(Command command, String[] args) {
        StringBuilder input = new StringBuilder(command.getName());
        for (String arg : args) {
            input.append(CommandDispatcher.ARGUMENT_SEPARATOR).append(arg);
        }
        return input.toString();
    }

    @Override
    public void onDisable() {
        bookLibrary.stop();
    }

    public void addListener(LibraryBookAddedListener listener) {
        bookLibrary.addListener(listener);
    }

    public void addListener(LibraryBookRemovedListener listener) {
        bookLibrary.addListener(listener);
    }

    public void removeListener(LibraryBookAddedListener listener) {
        bookLibrary.removeListener(listener);
    }

    public void removeListener(LibraryBookRemovedListener listener) {
        bookLibrary.removeListener(listener);
    }

    public ItemStack getBook(String bookId) {
        return bookLibrary.getBook(bookId);
    }
}
