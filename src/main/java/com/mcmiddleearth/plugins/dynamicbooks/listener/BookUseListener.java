package com.mcmiddleearth.plugins.dynamicbooks.listener;

import com.mcmiddleearth.plugins.dynamicbooks.manager.BookManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.logging.Logger;

public class BookUseListener implements Listener {

    private final BookManager bookManager;

    public BookUseListener(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.getType().equals(Material.WRITTEN_BOOK)) {
            return;
        }

        Player player = event.getPlayer();
        Action action = event.getAction();

        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
            /*
            * We will refresh the specific opened item, if  it  is a book managed by this plugin.
            * */
            bookManager.refreshPlayerBook(player, item);
        }
    }
}
