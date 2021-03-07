package part01.chapter02.levelA.task01.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers.length < 1) {
            return;
        }

        int minLengthNumber = getMinLengthNumber(numbers);
        System.out.format("Min length number = %d, length = %d\n", minLengthNumber, String.valueOf(minLengthNumber).length());
        int maxLengthNumber = getMaxLengthNumber(numbers);
        System.out.format("Max length number = %d, length = %d\n", maxLengthNumber, String.valueOf(maxLengthNumber).length());
    }

    private static int getMinLengthNumber(int[] numbers) {
        int minLength = String.valueOf(Integer.MAX_VALUE).length() + 1;

        int resultNumber = numbers[0];
        for (int number : numbers) {
            int numberLength = String.valueOf(number).length();
            if (numberLength < minLength) {
                resultNumber = number;
                minLength = numberLength;
            }
        }
        return resultNumber;
    }

    private static int getMaxLengthNumber(int[] numbers) {
        int maxLength = 0;

        int resultNumber = numbers[0];
        for (int number : numbers) {
            int numberLength = String.valueOf(number).length();
            if (numberLength > maxLength) {
                resultNumber = number;
                maxLength = numberLength;
            }
        }
        return resultNumber;
    }
}