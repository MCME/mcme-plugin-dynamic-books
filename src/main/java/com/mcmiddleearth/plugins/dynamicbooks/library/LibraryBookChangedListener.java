package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.books.Book;

public interface LibraryBookChangedListener {
    void handleEvent(String bookId, Book book);
}
