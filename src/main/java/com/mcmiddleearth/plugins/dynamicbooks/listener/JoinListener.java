package com.mcmiddleearth.plugins.dynamicbooks.listener;

import com.mcmiddleearth.plugins.dynamicbooks.bookspawner.BookSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final BookSpawner bookSpawner;

    public JoinListener(BookSpawner spawner) {
        this.bookSpawner = spawner;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();

        if (player.hasPlayedBefore())
            bookSpawner.spawnAllBooks(player);
        }
    }
}
