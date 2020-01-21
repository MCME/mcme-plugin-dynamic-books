package com.mcmiddleearth.plugins.dynamicbooks;

import com.google.common.base.Joiner;
import com.mcmiddleearth.plugins.dynamicbooks.command.CommandBookArgument;
import com.mcmiddleearth.plugins.dynamicbooks.command.CommandPlayerArgument;
import com.mcmiddleearth.plugins.dynamicbooks.command.CommandStringArgument;
import com.mcmiddleearth.plugins.dynamicbooks.library.*;
import com.mcmiddleearth.plugins.dynamicbooks.manager.BookManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
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

    public static final String OPEN_COMMAND = "dynbooks open";
    public static final String GIVE_COMMAND = "dynbooks give";
    public static final String BOOK_PREFIX = "Ancient Book";

    private BookManager bookManager;
    private BookLibrary bookLibrary;
    private CommandDispatcher<Player> commandDispatcher;

    public DynamicBooksPlugin() {
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        bookLibrary = new OfflineBookLibrary();
        bookManager = new BookManager(bookLibrary);

        // Check permissions based on spigot
        bookLibrary.open();

        this.commandDispatcher = new CommandDispatcher<>();

        commandDispatcher.register(
                LiteralArgumentBuilder.<Player>literal("library")
                        .then(
                                RequiredArgumentBuilder.<Player, String>argument("action", new CommandStringArgument("give", "open"))
                                        .then(
                                                RequiredArgumentBuilder.<Player, String>argument("book", new CommandBookArgument(bookLibrary))
                                                        .then(
                                                                RequiredArgumentBuilder.<Player, String>argument("player", new CommandPlayerArgument(getServer()))
                                                                        .executes(c -> {
                                                                                    Player player = getServer().getPlayer(c.getArgument("player", String.class));
                                                                                    doCommand(c.getArgument("action", String.class), c.getArgument("book", String.class), player);
                                                                                    return 1;
                                                                                }
                                                                        )
                                                        )
                                                        .executes(c -> {
                                                            doCommand(c.getArgument("action", String.class), c.getArgument("book", String.class), c.getSource());
                                                            return 1;
                                                        })
                                        )
                        )
        );

    }

    private void doCommand(String action, String book, Player source) {
        switch (action.toLowerCase()) {
            case "give":
                bookManager.giveBook(source, book);
                break;
            case "open":
                bookManager.openBook(source, book);
                break;
        }
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
        // Plugin shutdown logic
    }

    public void addListener(LibraryBookAddedListener listener) {
        bookLibrary.addListener(listener);
    }

    public void addListener(LibraryBookChangedListener listener) {
        bookLibrary.addListener(listener);
    }

    public void addListener(LibraryBookRemovedListener listener) {
        bookLibrary.addListener(listener);
    }

    public void removeListener(LibraryBookAddedListener listener) {
        bookLibrary.removeListener(listener);
    }

    public void removeListener(LibraryBookChangedListener listener) {
        bookLibrary.removeListener(listener);
    }

    public void removeListener(LibraryBookRemovedListener listener) {
        bookLibrary.removeListener(listener);
    }

    public ItemStack getBook(String bookId) {
        return bookLibrary.getBook(bookId);
    }
}
