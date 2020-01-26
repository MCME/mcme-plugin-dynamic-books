package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.jaxb.XmlBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.logging.Logger;

public class OfflineBookLibrary extends XmlBookLibrary {

    private final Unmarshaller unmarshaller;
    private final File dataFolder;

    public OfflineBookLibrary(File dataFolder) {
        this.dataFolder = dataFolder;

        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = JAXBContext.newInstance(XmlBook.class).createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        this.unmarshaller = unmarshaller;
    }

    @Override
    public List<XmlBook> fetchXmlBooks(ZonedDateTime lastUpdate) {
        Map<String, InputStream> files = getAllFiles();

        List<XmlBook> xmlBooks = new ArrayList<>();
        for (Map.Entry<String, InputStream> file : files.entrySet()) {
            try {
                Logger.getGlobal().info("File: " + file.getKey());
                XmlBook xmlBook = (XmlBook) unmarshaller.unmarshal(file.getValue());
                if (xmlBook != null) {
                    xmlBooks.add(xmlBook);
                }
                Logger.getGlobal().info("Added: " + file.getKey());
            } catch (JAXBException e) {
                e.printStackTrace();
                Logger.getGlobal().info("Ignored: " + file.getKey());
            } finally {
                try {
                    file.getValue().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xmlBooks;
    }

    private Map<String, InputStream> getAllFiles() {
        Map<String, InputStream> inputStreams = new HashMap<>();
        for (File file : Objects.requireNonNull(dataFolder.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".xml")) {
                try {
                    Logger.getGlobal().info("Checking if " + file.getName() + " is correct");
                    inputStreams.put(file.getName(), new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return inputStreams;
    }
}
