package com.mcmiddleearth.plugins.dynamicbooks.library;

public class BookParsingException extends Exception {

    private final String exceptionMessage;
    private final String bookId;

    public BookParsingException(String bookId, String exceptionMessage) {
        this.bookId = bookId;
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String getMessage() {
        if (bookId != null) {
            return String.format("(%s) encountered an error : %s", bookId, exceptionMessage);
        } else {
            return String.format("Did not find a book-id %s", exceptionMessage);
        }
    }
}
