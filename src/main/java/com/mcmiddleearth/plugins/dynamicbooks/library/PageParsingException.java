package com.mcmiddleearth.plugins.dynamicbooks.library;

public class PageParsingException extends Exception{

    private final String reference;

    public PageParsingException(String reference) {
        this.reference = reference;
    }

    @Override
    public String getMessage() {
        return reference;
    }
}
