package part01.chapter02.levelA.task05.java.demo;

import part01.chapter02.levelA.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers == null) {
            return;
        }

        int countOfNumbersWithAllEvenDigits = 0;
        int countOfNumbersWithEqualCountEvenAndOddDigits = 0;
        for (int number : numbers) {
            if (isAllDigitsEven(number)) {
                countOfNumbersWithAllEvenDigits++;
            } else if (isCountOfEvenAndOddDigitsEqual(number)) {
                countOfNumbersWithEqualCountEvenAndOddDigits++;
            }
        }
        System.out.println("Count of numbers, where all digits are even = " + countOfNumbersWithAllEvenDigits);
        System.out.println("Count of numbers, where count of even digits equals count of odd digits = " + countOfNumbersWithEqualCountEvenAndOddDigits);
    }

    private static boolean isCountOfEvenAndOddDigitsEqual(int number) {
        char[] charDigits = Integer.toString(Math.abs(number)).toCharArray();

        int countOfEvenDigits = 0;
        int countOfOddDigits = 0;
        for (char charDigit : charDigits) {
            if (Integer.parseInt(String.valueOf(charDigit)) % 2 == 0) {
                countOfEvenDigits++;
            } else {
                countOfOddDigits++;
            }
        }
        return countOfEvenDigits == countOfOddDigits;
    }

    private static boolean isAllDigitsEven(int number) {
        char[] charDigits = Integer.toString(Math.abs(number)).toCharArray();
        for (char charDigit : charDigits) {
            if (Integer.parseInt(String.valueOf(charDigit)) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}