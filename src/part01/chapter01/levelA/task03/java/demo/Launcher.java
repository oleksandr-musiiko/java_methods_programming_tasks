package part01.chapter01.levelA.task03.java.demo;

import java.util.concurrent.ThreadLocalRandom;

public class Launcher {

    public static void main(String[] args) {
        int countOfNumbers = 0;
        if (args.length > 0) {
            countOfNumbers = Integer.parseInt(args[0]);
        }
        for (int i = 0; i < countOfNumbers; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
        for (int i = 0; i < countOfNumbers; i++) {
            System.out.print(ThreadLocalRandom.current().nextInt() + "\t");
        }
    }
}
