package part02.chapter11.levelA.task02.java.generator;

import part02.chapter11.levelA.task02.java.model.Library;
import part02.chapter11.levelA.task02.java.model.User;

import java.util.*;

public class UserGenerator {

    private final String[] bookIDs;
    private final Random random;

    public UserGenerator(HashSet<String> bookIDs) {
        this.bookIDs = bookIDs.toArray(new String[0]);
        random = new Random();
    }

    public List<User> generateUsers(int count, int idLength, Library library) {
        IdGenerator idGenerator = new IdGenerator();
        Set<String> userIDs = new HashSet<>();
        List<User> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String id;
            do {
                id = idGenerator.generateId(idLength);
            } while (!userIDs.add(id));
            HashSet<String> countOfBooksIDsThatInterestingToUser = generateBookIDsThatInterestingToUser();
            result.add(new User(id, countOfBooksIDsThatInterestingToUser, library));
        }
        return result;
    }

    private HashSet<String> generateBookIDsThatInterestingToUser() {
        int countOfBooksIDsThatInterestingToUser = random.nextInt(bookIDs.length);
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < countOfBooksIDsThatInterestingToUser; i++) {
            String id;
            do {
                id = bookIDs[random.nextInt(bookIDs.length)];
            } while (!result.add(id));
        }
        return result;
    }
}