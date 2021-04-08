package part02.chapter11.levelA.task02.java.helper;

import java.util.Random;

public class Sleeper {

    private static final Random random = new Random();

    public static void sleepRandomTime(int bound) {
        try {
            Thread.sleep(random.nextInt(bound));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
