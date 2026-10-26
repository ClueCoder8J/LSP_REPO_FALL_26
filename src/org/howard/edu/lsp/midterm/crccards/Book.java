package org.howard.edu.lsp.midterm.crccards;

public class Book {
    String isbn;
    String title;
    String author;
    boolean availability;

    /**
     * Creates a new book object
     * @param isbn The isbn number for the book
     * @param title The title of the book
     * @param author The author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availability = true;
    }

}