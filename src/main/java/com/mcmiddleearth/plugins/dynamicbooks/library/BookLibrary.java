package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.books.Book;

import java.time.ZonedDateTime;
import java.util.*;

public abstract class BookLibrary {

    private List<LibraryBookAddedListener> bookAddedListeners = new ArrayList<>();
    private List<LibraryBookChangedListener> bookChangedListeners = new ArrayList<>();
    private List<LibraryBookRemovedListener> bookRemovedListeners = new ArrayList<>();

    private Map<String, Book> currentBooks = new HashMap<>();

    protected BookLibrary() {
        refresh(new HashSet<>(),null);
    }

    // We refresh our library based on our current books and the last time we updated anything.
    abstract protected void refresh(Set<String> currentBooks, ZonedDateTime lastUpdate);

    // Book management
    protected void addBook(Book book) {
        currentBooks.put(book.getBookId(), book);
        notifyBookAdded(book);
    }

    protected void updateBook(String bookId, Book book) {
        currentBooks.put(bookId, book);
        notifyBookChanged(book);
    }

    protected void removeBook(String bookId) {
        currentBooks.remove(bookId);
        notifyBookRemoved(bookId);
    }

    // Listener management
    public void setListener(LibraryBookAddedListener listener) {
        bookAddedListeners.add(listener);
    }

    public void removeListener(LibraryBookAddedListener listener) {
        bookAddedListeners.remove(listener);
    }

    public void setListener(LibraryBookChangedListener listener) {
        bookChangedListeners.add(listener);
    }

    public void removeListener(LibraryBookChangedListener listener) {
        bookChangedListeners.remove(listener);
    }

    public void setListener(LibraryBookRemovedListener listener) {
        bookRemovedListeners.add(listener);
    }

    public void removeListener(LibraryBookRemovedListener listener) {
        bookRemovedListeners.remove(listener);
    }

    // Notifiers for the listeners
    private void notifyBookAdded(Book book) {
        for (LibraryBookAddedListener listener : bookAddedListeners) {
            listener.handleEvent(book.getBookId(), book);
        }
    }

    private void notifyBookChanged(Book book) {
        for (LibraryBookChangedListener listener : bookChangedListeners) {
            listener.handleEvent(book.getBookId(), book);
        }
    }

    private void notifyBookRemoved(String bookId) {
        for (LibraryBookRemovedListener listener : bookRemovedListeners) {
            listener.handleEvent(bookId);
        }
    }
}
