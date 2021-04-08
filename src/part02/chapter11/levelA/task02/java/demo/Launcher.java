package part02.chapter11.levelA.task02.java.demo;

import part02.chapter11.levelA.task02.java.generator.BookGenerator;
import part02.chapter11.levelA.task02.java.generator.UserGenerator;
import part02.chapter11.levelA.task02.java.helper.Sleeper;
import part02.chapter11.levelA.task02.java.model.*;
import part02.chapter11.levelA.task02.java.util.Constants;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        BookGenerator.GeneratedBooksData generatedBooksData = new BookGenerator().generateBooks(15000, 15);
        Library library = new Library(generatedBooksData.getBooks());
        library.start();
        List<User> users = new UserGenerator(generatedBooksData.getBookIDs()).generateUsers(200, 10, library);
        for (User user : users) {
            library.addUserToQuery(user);
            Sleeper.sleepRandomTime(Constants.MAX_TIME_FOR_QUERY_TO_REGISTER_USERS);
        }
    }
}
