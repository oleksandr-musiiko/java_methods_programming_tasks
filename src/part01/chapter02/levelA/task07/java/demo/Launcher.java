package part01.chapter02.levelA.task07.java.demo;

import part01.chapter02.levelA.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers == null) {
            return;
        }

        for (int number : numbers) {
            if (isAllDigitsDifferent(number)) {
                System.out.println("First number, where all digits are different = " + number);
                return;
            }
        }
        System.out.println("Number, where all digits are different, not found");
    }

    private static boolean isAllDigitsDifferent(int number) {
        byte[] countsOfDigits = new byte[10];

        char[] charDigits = String.valueOf(Math.abs(number)).toCharArray();
        for (char charDigit : charDigits) {
            int digit = Integer.parseInt(Character.toString(charDigit));
            countsOfDigits[digit]++;
        }
        for (int countsOfDigit : countsOfDigits) {
            if (countsOfDigit > 1) {
                return false;
            }
        }
        return true;
    }
}