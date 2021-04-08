package part02.chapter11.levelA.task02.java.helper;

import part02.chapter11.levelA.task02.java.model.book.Book;
import part02.chapter11.levelA.task02.java.model.User;

import java.util.HashSet;
import java.util.List;

public class MessagePrinter {

    private static final String UNDERLINE = "\n____________________________________";

    public static void printBookWasNotFound(String invalidBookID) {
        System.out.println("Book with id = " + invalidBookID + " wasn't found" + UNDERLINE);
    }

    public static void printBookWasUsedByAnotherUser(String bookID) {
        System.out.println("Book with id = " + bookID + " used by another reader now" + UNDERLINE);
    }

    public static void printBooksThatAreOnHandNow(List<Book> bookList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Books, that are on hand now (size=" + bookList.size() + "):");
        for (Book book : bookList) {
            stringBuilder.append("\n" + book);
        }
        stringBuilder.append(UNDERLINE);
        System.out.println(stringBuilder.toString());
    }

    public static void printUserWasRegistered(User user) {
        System.out.println("user with id = " + user.getUserId() + " was registered!" + UNDERLINE);
    }

    public static void printUserListenBookInTheReadingRoom(User user, Book book) {
        System.out.println("user with id = " + user.getUserId() + " listen the book with id = " + book.getId() + " in the Reading room" + UNDERLINE);
    }

    public static void printUserListenBookOutsideTheLibrary(User user, Book book) {
        System.out.println("user with id = " + user.getUserId() + " listen the book with id = " + book.getId() + " outside the library" + UNDERLINE);
    }

    public static void printUserGetBookFromLibrary(User user, Book book) {
        System.out.println("user with id = " + user.getUserId() + " get the book with id = " + book.getId() +  getBooksInHandOfUser(user) + UNDERLINE);
    }

    public static void printUserReturnBookToLibrary(User user, Book book) {
        System.out.println("user with id = " + user.getUserId() + " return the book with id = " + book.getId()  + getBooksInHandOfUser(user) + UNDERLINE);
    }

    private static String getBooksInHandOfUser(User user) {
        StringBuilder result = new StringBuilder();
        HashSet<Book> booksInHand = user.getBooks();
        if (!booksInHand.isEmpty()) {
            result.append("\nBooks in hand:");
            for (Book book : booksInHand) {
                result.append("\n" + book);
            }
            return result.toString();
        }
        return "";
    }
}