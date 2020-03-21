package com.mcmiddleearth.plugins.dynamicbooks.library;

import com.mcmiddleearth.plugins.dynamicbooks.books.Book;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class BookLibrary {

    private ScheduledExecutorService scheduledThreadPoolExecutor;
    private ZonedDateTime lastUpdate;

    private List<LibraryBookAddedListener> bookAddedListeners = new ArrayList<>();
    private List<LibraryBookChangedListener> bookChangedListeners = new ArrayList<>();
    private List<LibraryBookRemovedListener> bookRemovedListeners = new ArrayList<>();

    private Map<String, Book> currentBooks = new HashMap<>();
    private Map<String, String> ingameNametoBookIdMap = new HashMap<>();

    // We refresh our library based on our current books and the last time we updated anything.
    abstract protected void refresh(Set<String> currentBooks, ZonedDateTime lastUpdate);

    public void start(int intermediateDelay) {
        if (scheduledThreadPoolExecutor == null) {
            Logger.getGlobal().info("Starting Library at fixed delay: " + intermediateDelay);
            scheduledThreadPoolExecutor = Executors.newSingleThreadScheduledExecutor();
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(this::executingCycle,0, intermediateDelay, TimeUnit.SECONDS);
        }
    }

    public void stop() {
        scheduledThreadPoolExecutor.shutdown();
    }

    public String getBookIdFromIngameName(String ingameName) {
        return ingameNametoBookIdMap.get(ingameName);
    }

    public void restart(int intermediateDelay) {
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdown();
        }
        start(intermediateDelay);
    }

    public boolean verifyAccess(String book, Player source, Book.Permission permission) {
        if (source.hasPermission(permission.getBypassPermission())) {
            return true;
        }

        String bookPermission = currentBooks.get(book).getPermission(permission);

        if (bookPermission != null) {
            return source.hasPermission(bookPermission);
        }
        return false;
    }

    private void executingCycle() {
        refresh(new HashSet<>(currentBooks.keySet()),lastUpdate);
        lastUpdate = ZonedDateTime.now();
    }

    // Book management
    protected void addBook(Book book) {
        currentBooks.put(book.getBookId(), book);
        ingameNametoBookIdMap.put(Book.getIngameBookName(book.getBookId()),book.getBookId());
        notifyBookAdded(book);
    }

    protected void updateBook(String bookId, Book book) {
        currentBooks.put(bookId, book);
        //notifyBookChanged(book);
    }

    protected void removeBook(String bookId) {
        currentBooks.remove(bookId);
        ingameNametoBookIdMap.remove(Book.getIngameBookName(bookId));
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
