package com.mcmiddleearth.plugins.dynamicbooks.books;

import net.md_5.bungee.api.chat.BaseComponent;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {

    private final String bookId;
    private final String author;
    private List<BaseComponent[]> pages = new ArrayList<>();

    public BookBuilder(String bookId, String author) {
        this.bookId = bookId;
        this.author = author;
    }

    public BookBuilder withPage(BaseComponent[] page) {
        pages.add(page);
        return this;
    }

    public Book build() {
        return new Book(bookId, author, pages);
    }
}
