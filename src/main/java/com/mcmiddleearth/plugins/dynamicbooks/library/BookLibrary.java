package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.books.Book;
import org.bukkit.inventory.ItemStack;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BookLibrary {

    private List<LibraryBookAddedListener> bookAddedListeners = new ArrayList<>();
    private List<LibraryBookChangedListener> bookChangedListeners = new ArrayList<>();
    private List<LibraryBookRemovedListener> bookRemovedListeners = new ArrayList<>();

    private Map<String, Book> currentBooks = new HashMap<>();

    // We refresh our library based on our current books and the last time we updated anything.
    abstract protected void refresh(Set<String> currentBooks, ZonedDateTime lastUpdate);

    public void open() {
        refresh(new HashSet<>(),null);
    }

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

    public void addListener(LibraryBookAddedListener listener) {
        bookAddedListeners.add(listener);
    }

    public void removeListener(LibraryBookAddedListener listener) {
        bookAddedListeners.remove(listener);
    }

    public void addListener(LibraryBookChangedListener listener) {
        bookChangedListeners.add(listener);
    }

    public void removeListener(LibraryBookChangedListener listener) {
        bookChangedListeners.remove(listener);
    }

    public void addListener(LibraryBookRemovedListener listener) {
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

    public List<ItemStack> getAllBooksAsItemStacks() {
        return currentBooks.values().stream().map(x -> x.getItem()).collect(Collectors.toList());
    }

    public ItemStack getBook(String bookId) {
        Book book = currentBooks.get(bookId);
        if (book != null) {
            return book.getItem();
        }
        return null;
    }

    public Set<String> getAllBookIds() {
        return currentBooks.keySet();
    }

    public boolean exists(String book) {
        return currentBooks.containsKey(book);
    }

    public String getIngameBookName(String book) {
        return Book.getIngameBookName(book);
    }
}
