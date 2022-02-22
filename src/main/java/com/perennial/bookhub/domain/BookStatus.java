package com.perennial.bookhub.domain;

public enum BookStatus {
    AVAILABLE("Available"), TAKEN("Taken"), DISCONTINUED("Discontinued");

    public final String label;

    BookStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

}
