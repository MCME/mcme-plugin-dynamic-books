package com.mcmiddleearth.plugins.dynamicbooks;

import com.mcmiddleearth.plugins.dynamicbooks.jaxb.XMLBook;
import com.mcmiddleearth.plugins.dynamicbooks.library.BookLibrary;
import com.mcmiddleearth.plugins.dynamicbooks.library.OfflineBookLibrary;
import com.mcmiddleearth.plugins.dynamicbooks.listener.JoinListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.bind.JAXBContext;
import java.io.File;

public final class DynamicBooksPlugin extends JavaPlugin {

    private Listener joinListener;

    private BookLibrary bookLibrary;

    @Override
    public void onEnable() {
        // Plugin startup logic
        joinListener = new JoinListener();
        bookLibrary = new OfflineBookLibrary();
        getServer().getPluginManager().registerEvents(joinListener,this);

        XMLBook book;
        book.getPages().getPage().get(0).getContent();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
