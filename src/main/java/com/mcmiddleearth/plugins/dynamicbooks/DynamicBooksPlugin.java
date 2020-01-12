package com.mcmiddleearth.plugins.dynamicbooks;

import com.mcmiddleearth.plugins.dynamicbooks.bookspawner.BookSpawner;
import com.mcmiddleearth.plugins.dynamicbooks.listener.JoinListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DynamicBooksPlugin extends JavaPlugin {

    private Listener joinListener;

    @Override
    public void onEnable() {
        // Plugin startup logic
        joinListener = new JoinListener(new DummyClass(), new BookSpawner());
        getServer().getPluginManager().registerEvents(joinListener,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
