package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.jaxb.XmlBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class OfflineBookLibrary extends XmlBookLibrary {

    private final Unmarshaller unmarshaller;

    public OfflineBookLibrary() {
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
        List<InputStream> files = getAllFiles();

        List<XmlBook> xmlBooks = new ArrayList<>();
        for (InputStream file : files) {
            try {
                XmlBook xmlBook = (XmlBook) unmarshaller.unmarshal(file);
                if (xmlBook != null) {
                    xmlBooks.add(xmlBook);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return xmlBooks;
    }

    private List<InputStream> getAllFiles() {
        ArrayList<InputStream> inputStreams = new ArrayList<>();
        inputStreams.add(OfflineBookLibrary.class.getResourceAsStream("/testbook.xml"));
        inputStreams.add(OfflineBookLibrary.class.getResourceAsStream("/warping-menu.xml"));
        return inputStreams;
    }
}
