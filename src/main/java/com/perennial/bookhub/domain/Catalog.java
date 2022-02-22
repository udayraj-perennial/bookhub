package com.perennial.bookhub.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a service class that holds collection of books and provides CRUD and searching facilities for book catalog
 */
public class Catalog {
    private static final Logger logger = LogManager.getLogger(Catalog.class);
    /**
     * Collection of books
     */
    private final HashMap<String, List<Book>> books;

    public Catalog() {
        books = new HashMap<>();
    }

    public void add(Book book) {
        if (null == book) {
            logger.error("Book is null");
            return;
        }
        List<Book> existingCopies = books.get(book.getTitle());
        if (null != existingCopies) {
            existingCopies.add(book);
        } else {
            List<Book> copies = new ArrayList<>();
            copies.add(book);
            books.put(book.getTitle(), copies);
        }
    }
}
