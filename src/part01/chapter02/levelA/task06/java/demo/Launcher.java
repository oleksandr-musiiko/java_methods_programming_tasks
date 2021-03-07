package part01.chapter02.levelA.task06.java.demo;

import part01.chapter02.levelA.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers == null) {
            return;
        }

        for (int number : numbers) {
            if (areDigitsOfNumberInAscendingOrder(number)) {
                System.out.println("First number, where digits in ascending order = " + number);
                return;
            }
        }
        System.out.println("Number, where digits in ascending order, not found");
    }

    private static boolean areDigitsOfNumberInAscendingOrder(int number) {
        char[] charDigits = String.valueOf(Math.abs(number)).toCharArray();
        int previousDigit = -1;
        for (char charDigit : charDigits) {
            int digit = Integer.parseInt(String.valueOf(charDigit));
            if (previousDigit >= digit) {
                return false;
            } else {
                previousDigit = digit;
            }
        }
        return true;
    }
}