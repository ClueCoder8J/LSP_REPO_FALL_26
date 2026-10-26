package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    private final Map<String, Book> books = new TreeMap<>();
    final int borrowingLimit = 3;

    /**
     * Add a new book to the library
     * @param book Book to be added
     * @throws IllegalArgumentException Exception thrown when book already exists
     */
    public void addBook(Book book) throws IllegalArgumentException {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book already exists in Library");
        }
        else {
            books.put(book.getIsbn(), book);
        }
    }

    /**
     * Locates a book in the library
     * @param isbn ISBN to search for book by
     * @return Book object or null
     */
    public Book findBook(String isbn) {
        return books.getOrDefault(isbn, null);
    }

    /**
     * Borrows a book from the library
     * @param isbn ISBN of book being borrowed
     * @throws IllegalArgumentException Raised if book's ISBN is not found in the library
     * @throws IllegalStateException Raised if borrowing threshold has been reached
     */
    public void borrowBook(String isbn) throws IllegalArgumentException, IllegalStateException {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book is not available at this library");
        }

        if (this.getBorrowedBookCount() >= borrowingLimit) {
            throw new IllegalStateException("No more books can be borrowed at this time");
        }

        book.borrowBook();
    }

    /**
     * Returns a book to the library
     * @param isbn ISBN of book being returned
     * @throws IllegalArgumentException Raised if book's ISBN is not found in the library
     */
    public void returnBook(String isbn) throws IllegalArgumentException {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book is not from this library");
        }

        book.returnBook();
    }

    /**
     * Shows the books currently available to be borrowed
     * @return List of available books
     */
    public List<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    /**
     * Shows all books that have the provided author
     * @param author Author by which to search for books
     * @return List of books with supplied author
     */
    public List<Book> getBooksByAuthor(String author) {
        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    /**
     * Shows books in sorted order
     * @return List of books sorted lexicographically by ISBN
     */
    public List<Book> getBooksSortedByIsbn() {
        return new ArrayList<>(books.values());
    }

    public int getBorrowedBookCount() {
        int count = 0;
        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}

