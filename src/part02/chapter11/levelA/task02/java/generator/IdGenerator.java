package part02.chapter11.levelA.task02.java.generator;

import java.util.Random;

public class IdGenerator {

    private final String UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String DIGITS = "0123456789";
    private final String SYMBOLS_FOR_ID = UPPER_LETTERS + UPPER_LETTERS.toLowerCase() + DIGITS;

    private final Random random;

    public IdGenerator() {
        random = new Random();
    }

    public String generateId(int idLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < idLength; i++) {
            result.append(SYMBOLS_FOR_ID.charAt(random.nextInt(SYMBOLS_FOR_ID.length())));
        }
        return result.toString();
    }
}
