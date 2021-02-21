package part01.chapter01.levelB.task06.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        for (int number : numbers) {
            if (isNumberThreeDigit(number)) {
                if (areAllDigitsDifferentInNumberOfThreeDigits(number)) {
                    System.out.print(number + "\t");
                }
            }
        }
    }

    private static boolean areAllDigitsDifferentInNumberOfThreeDigits(int number) {
        int[] digits = new int[3];
        for (int digit : digits) {
            digit = -1;
        }
        int temp = number;
        int indexOfDigit = 0;
        while (temp >= 1) {
            int digit = temp % 10;
            for (int element:
                 digits) {
                if (element == digit) {
                    return false;
                }
            }
            digits[indexOfDigit++] = digit;
            temp = temp / 10;
        }
        return true;
    }

    private static boolean isNumberThreeDigit(int number) {
        return (number / 100 >= 1 && number / 100 < 10);
    }
}
