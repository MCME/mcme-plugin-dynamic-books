package com.mcmiddleearth.plugins.dynamicbooks.listener;

import com.mcmiddleearth.plugins.dynamicbooks.manager.BookManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final BookManager bookManager;

    public JoinListener(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        bookManager.refreshPlayerAndRemoveFaultyBooks(event.getPlayer());
    }
}
