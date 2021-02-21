package part01.chapter01.levelB.task08.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader().getArrayOfNumbersFromConsole());
        for (int number :
                numbers) {
            if (isPrimeNumber(number)) {
                System.out.print(number + "\t");
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 1) {
            return false;
        }
        if (number == 1) {
            return true;
        }
        int untilNumber = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < untilNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}