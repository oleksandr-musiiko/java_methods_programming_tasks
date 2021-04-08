package part02.chapter11.levelA.task02.java.model;

import part02.chapter11.levelA.task02.java.helper.MessagePrinter;
import part02.chapter11.levelA.task02.java.helper.Sleeper;
import part02.chapter11.levelA.task02.java.model.book.Book;
import part02.chapter11.levelA.task02.java.model.book.BookLocation;
import part02.chapter11.levelA.task02.java.model.book.BooksUsingTerms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import static part02.chapter11.levelA.task02.java.util.Constants.*;

public class User extends Thread {

    private final int MAX_COUNT_OF_BOOKS_FOR_READING = 3;

    private final String userId;
    private volatile HashSet<Book> books;
    private final HashSet<String> bookIDsThatUserInterestsToGet;
    private volatile Library library;
    private final Random random;

    public User(String userId, HashSet<String> bookIDsThatUserInterestsToGet, Library library) {
        this.userId = userId;
        this.bookIDsThatUserInterestsToGet = bookIDsThatUserInterestsToGet;
        this.books = new HashSet<>();
        this.random = new Random();
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) {
                return;
            }
            if (!books.isEmpty()) {
                Book bookForAction = getRandomBookForAction();
                Thread actionWithBook = chooseActionWithBook(bookForAction);
                actionWithBook.start();
                try {
                    actionWithBook.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Sleeper.sleepRandomTime(MAX_TIME_FOR_WAIT_OF_USER);
            }
            getNewBooks();
        }
    }

    private Thread listenInTheReadingRoom(Book book) {
        return new Thread(() -> {
            book.setBookLocation(BookLocation.READING_ROOM);
            MessagePrinter.printUserListenBookInTheReadingRoom(this, book);
            Sleeper.sleepRandomTime(MAX_TIME_FOR_READING_INT_THE_READING_ROOM);
            returnBookToTheLibraryOrContinueUsing(book);
        });
    }

    private Thread listenOutsideTheLibrary(Book book) {
        return new Thread(() -> {
            returnBooksThenTermsUsingOnlyInLibrary();
            book.setBookLocation(BookLocation.USER);
            MessagePrinter.printUserListenBookOutsideTheLibrary(this, book);
            Sleeper.sleepRandomTime(MAX_TIME_FOR_READING_OUTSIDE_THE_LIBRARY);
            returnBookToTheLibraryOrContinueUsing(book);
        });
    }

    private Thread chooseActionWithBook(Book book) {
        switch (book.getBooksUsingTerm()) {
            case READING_ROOM: {
                return listenInTheReadingRoom(book);
            }
            case IN_HAND: {
                switch (random.nextInt(2)) {
                    case 0: {
                        return listenInTheReadingRoom(book);
                    }
                    case 1: {
                        return listenOutsideTheLibrary(book);
                    }
                    default:
                        throw new IllegalStateException();
                }
            }
            default:
                throw new IllegalStateException();
        }
    }

    private Book getRandomBookForAction() {
        return books.toArray(new Book[0])[random.nextInt(books.size())];
    }

    private void getNewBooks() {
        int countForGet = random.nextInt(MAX_COUNT_OF_BOOKS_FOR_READING - books.size() + 1);
        for (int i = 0; i < countForGet; i++) {
            if (bookIDsThatUserInterestsToGet.size() == 0) {
                return;
            }
            String idOfBook;
            do {
                idOfBook = generateBookForGetFromLibrary();
            } while (!giveBook(idOfBook));
        }
    }

    private String generateBookForGetFromLibrary() {
        String[] books = bookIDsThatUserInterestsToGet.toArray(new String[0]);
        return books[random.nextInt(books.length)];
    }

    private boolean isOpenToGetBook() {
        return books.size() < MAX_COUNT_OF_BOOKS_FOR_READING;
    }

    private boolean giveBook(String bookId) {
        if (isOpenToGetBook()) {
            return orderBook(bookId);
        } else {
            return false;
        }
    }

    private boolean orderBook(String bookId) {
        Book book = library.getBookToUser(bookId);
        if (book != null) {
            book.setUser(this);
            books.add(book);
            MessagePrinter.printUserGetBookFromLibrary(this, book);
            bookIDsThatUserInterestsToGet.remove(book.getId());
            return true;
        } else {
            return false;
        }
    }

    private void returnBook(Book book) {
        books.remove(book);
        book.returnToTheLibrary();
        MessagePrinter.printUserReturnBookToLibrary(this, book);
        bookIDsThatUserInterestsToGet.add(book.getId());
    }

    private void returnBookToTheLibraryOrContinueUsing(Book book) {
        if (random.nextInt(6) == 0) {
            returnBook(book);
        }
    }

    private void returnBooksThenTermsUsingOnlyInLibrary() {
        for (Book book : new ArrayList<>(books)) {
            if (book.getBooksUsingTerm() == BooksUsingTerms.READING_ROOM) {
                returnBook(book);
            }
        }
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public String getUserId() {
        return userId;
    }
}