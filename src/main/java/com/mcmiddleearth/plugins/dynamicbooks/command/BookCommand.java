package com.mcmiddleearth.plugins.dynamicbooks.command;

import com.mcmiddleearth.plugins.dynamicbooks.DynamicBooksPlugin;
import com.mcmiddleearth.plugins.dynamicbooks.library.BookLibrary;
import com.mcmiddleearth.plugins.dynamicbooks.manager.BookManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import org.bukkit.entity.Player;

public class BookCommand extends CommandDispatcher<Player> {

    private final BookLibrary bookLibrary;
    private final BookManager bookManager;
    private final DynamicBooksPlugin bookPlugin;

    public BookCommand(DynamicBooksPlugin bookPlugin, BookLibrary bookLibrary, BookManager bookManager) {
        this.bookLibrary = bookLibrary;
        this.bookManager = bookManager;
        this.bookPlugin = bookPlugin;

        register(
                LiteralArgumentBuilder.<Player>literal("library")
                        .then(
                                RequiredArgumentBuilder.<Player, String>argument("action", new CommandStringArgument("give", "open", "reload"))
                                        .then(
                                                RequiredArgumentBuilder.<Player, String>argument("book", new CommandBookArgument(bookLibrary))
                                                        .then(
                                                                RequiredArgumentBuilder.<Player, String>argument("player", new CommandPlayerArgument(bookPlugin.getServer()))
                                                                        .executes(c -> {
                                                                                    Player player = bookPlugin.getServer().getPlayer(c.getArgument("player", String.class));
                                                                                    doCommand(c.getArgument("action", String.class), c.getArgument("book", String.class), player, true);
                                                                                    return 1;
                                                                                }
                                                                        )
                                                        )
                                                        .executes(c -> {
                                                            doCommand(c.getArgument("action", String.class), c.getArgument("book", String.class), c.getSource(), false);
                                                            return 1;
                                                        })
                                        )
                        )
        );
    }

    private void doCommand(String action, String book, Player source, boolean remote) {
        switch (action.toLowerCase()) {
            case "give":
                bookManager.giveBook(source, book, remote);
                break;
            case "open":
                bookManager.openBook(source, book, remote);
                break;
            case "reload":
                if (source.hasPermission("library.reload")) {
                    bookPlugin.reloadConfig();
                    bookLibrary.restart(bookPlugin.getConfig().getInt("refresh.interval",900));
                }
                break;
        }
    }
}
