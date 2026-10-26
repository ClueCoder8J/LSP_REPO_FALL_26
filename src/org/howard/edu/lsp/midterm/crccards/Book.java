package org.howard.edu.lsp.midterm.crccards;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    boolean availability;

    /**
     * Creates a new book object
     * @param isbn The ISBN for the book
     * @param title The title of the book
     * @param author The author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availability = true;
    }

    /**
     * Get ISBN for a book
     * @return isbn
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Get book title
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Get author name for a book
     * @return author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Check availability status of a book
     * @return Availability
     */
    public boolean isAvailable() {
        return this.availability;
    }

    /**
     * Makes book unavailable
     * @throws IllegalStateException Exception for when method and availability don't match
     */
    public void borrowBook() throws IllegalStateException {
        if (this.isAvailable()) {
            this.availability = false;
        }
        else throw new IllegalStateException("Book is already borrowed");

    }

    /**
     * Makes book available
     * @throws IllegalStateException Exception for when method and availability don't match
     */
    public void returnBook() throws IllegalStateException {
        if (!this.isAvailable()) {
            this.availability = true;
        }
        else throw new IllegalStateException("Book has not been borrowed");
    }

    /**
     * Returns the book's name, author and availability
     * @return String describing book's name, author and availability
     */
    public String toString() {
        final String status = this.isAvailable() ? "AVAILABLE" : "BORROWED";

        return this.getTitle() + " by " + this.getAuthor() + " " + status;
    }



}