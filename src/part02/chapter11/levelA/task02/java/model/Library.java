package part02.chapter11.levelA.task02.java.model;

import part02.chapter11.levelA.task02.java.helper.MessagePrinter;
import part02.chapter11.levelA.task02.java.helper.Sleeper;
import part02.chapter11.levelA.task02.java.model.book.Book;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static part02.chapter11.levelA.task02.java.util.Constants.TIME_DELAY_FOR_PRINTING_STATUS_OF_LIBRARY;

public class Library extends Thread {

    private volatile Queue<User> usersToRegistration;
    private volatile HashSet<Book> books;
    private ReentrantLock reentrantLock;

    public Library(HashSet<Book> books) {
       this.books = books;
       usersToRegistration = new LinkedList<>();
       reentrantLock = new ReentrantLock();
    }

    @Override
    public void run() {
        Thread printingStatus = getThreadPrintingStatusOfBooksThatUsingNow();
        printingStatus.start();
        while (true) {
            if (isInterrupted()) {
                return;
            }
            while (!usersToRegistration.isEmpty()) {
                registerUser();
            }
        }
    }

    public void addUserToQuery(User user) {
        usersToRegistration.add(user);
    }

    public Book getBookToUser(String bookId) {
        reentrantLock.lock();
        Book book = foundBook(bookId);
        if (book == null) {
            reentrantLock.unlock();
            return null;
        }
        if (isBookReadyToOrder(book)) {
            reentrantLock.unlock();
            return book;
        } else {
            MessagePrinter.printBookWasUsedByAnotherUser(book.getId());
        }
        reentrantLock.unlock();
        return null;
    }

    private boolean isBookReadyToOrder(Book book) {
        return book.getUser() == null;
    }

    private Book foundBook(String bookID) {
        Book result = null;
        for (Book book : books) {
            if (book.getId().equals(bookID)) {
                result = book;
                break;
            }
        }
        if (result == null) {
            MessagePrinter.printBookWasNotFound(bookID);
            return null;
        } else {
            return result;
        }
    }

    private void registerUser() {
        User user = usersToRegistration.poll();
        if (user != null) {
            user.start();
            MessagePrinter.printUserWasRegistered(user);
        }
    }

    private Thread getThreadPrintingStatusOfBooksThatUsingNow() {
        return new Thread(() -> {
            while (true) {
                if (isInterrupted()) {
                    return;
                }
                printBooksThatUsingNow();
                Sleeper.sleep(TIME_DELAY_FOR_PRINTING_STATUS_OF_LIBRARY);
            }
        });
    }

    private void printBooksThatUsingNow() {
        MessagePrinter.printBooksThatAreOnHandNow(getBooksThatUsingNow());
    }

    private List<Book> getBooksThatUsingNow() {
        List<Book> booksThatUsingNow = new ArrayList<>();
        for (Book book : books) {
            if (book.getUser() != null) {
                booksThatUsingNow.add(book);
            }
        }
        return booksThatUsingNow;
    }
}