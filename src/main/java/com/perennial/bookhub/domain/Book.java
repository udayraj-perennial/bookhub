package com.perennial.bookhub.domain;

import com.perennial.bookhub.exceptions.InvalidNameException;
import com.perennial.bookhub.util.TextUtil;
import lombok.Getter;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class Book {
    /**
     * Holds the title of a book
     */
    @Getter
    private final String title;
    /**
     * Reference of the user who owns this book
     */
    @Getter
    private final User owner;
    /**
     * Unique number to refer to the book
     */
    private final long ISBN;
    /**
     * One or more authors
     */
    private final Set<String> authors;
    /**
     * Search keywords, optional
     */
    private final Set<String> keywords;
    /**
     * Holds if this book is available, taken or discontinued
     */
    private BookStatus status;
    /**
     * Constructor for a single author name
     *
     * @param ISBN
     * @param title
     * @param owner
     * @param authorName
     */
    public Book(long ISBN, String title, User owner, String authorName) {
        this.ISBN = ISBN;
        this.title = title;
        this.owner = owner;
        authors = new HashSet<>();
        keywords = new HashSet<>();
        authors.add(authorName);
    }
    /**
     * Constructor for multiple author names
     *
     * @param title
     * @param owner
     * @param ISBN
     * @param authors
     */
    public Book(String title, User owner, long ISBN, Set<String> authors) {
        this.title = title;
        this.owner = owner;
        this.ISBN = ISBN;
        this.authors = new HashSet<>();
        keywords = new HashSet<>();
        for (String authorName : authors) {
            if (TextUtil.isAlpha(authorName)) {
                this.authors.add(authorName);
            } else {
                throw new InvalidNameException();
            }
        }
    }
    /**
     * Make the book available
     */
    public void markAvailable() { status = BookStatus.AVAILABLE; }
    /**
     * Returns true if the book is available
     *
     * @return
     */
    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }
    /**
     * Set the book as taken
     */
    public void markTaken() { status = BookStatus.TAKEN; }
    /**
     * True if the book status is taken
     * @return
     */
    public boolean isTaken() { return status == BookStatus.TAKEN; }
    /**
     * Mark the book as discontinued, DO NOT delete it to keep the history
     */
    public void discontinue() {
        status = BookStatus.DISCONTINUED;
    }
    /**
     * True if the status is discontinued 👎
     * @return
     */
    public boolean isDiscontinued () {
        return status == BookStatus.DISCONTINUED;
    }
    /**
     * Matches the partial search term with the author names and returns if any author names match with given search term
     *
     * @param searchTerm
     * @return
     */
    public boolean hasAuthorLike(String searchTerm) {
        Optional<String> matchingName = authors.stream().filter(name -> name.matches(searchTerm)).findAny();
        return matchingName.isPresent();
    }
    public boolean hasKeywordLike(String searchTerm) {
        Optional<String> matchingKeyword = keywords.stream().filter(name -> name.matches(searchTerm)).findAny();
        return matchingKeyword.isPresent();
    }
    /**
     * Checks if the given ISBN matches with the book's ISBN
     *
     * @param ISBN
     * @return
     */
    public boolean hasISBN(long ISBN) {
        return ISBN == this.ISBN;
    }

    public void applyKeyword(String keyword) {
        keywords.add(keyword);
    }
}
