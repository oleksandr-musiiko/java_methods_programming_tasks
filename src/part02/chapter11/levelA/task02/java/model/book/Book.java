package part02.chapter11.levelA.task02.java.model.book;

import part02.chapter11.levelA.task02.java.model.User;

public class Book {

    private final String id;
    private final BooksUsingTerms booksUsingTerm;
    private volatile User user;
    private volatile BookLocation bookLocation;

    public Book(String id, BooksUsingTerms booksUsingTerm) {
        this.id = id;
        this.booksUsingTerm = booksUsingTerm;
        user = null;
        bookLocation = BookLocation.LIBRARY;
    }

    public void returnToTheLibrary() {
        user = null;
        bookLocation = BookLocation.LIBRARY;
    }

    public String getId() {
        return id;
    }

    public BooksUsingTerms getBooksUsingTerm() {
        return booksUsingTerm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBookLocation(BookLocation bookLocation) {
        this.bookLocation = bookLocation;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", booksUsingTerm=" + booksUsingTerm +
                ", user=" + user.getUserId() +
                ", bookLocation=" + bookLocation +
                '}';
    }
}