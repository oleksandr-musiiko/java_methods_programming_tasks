package part01.chapter02.levelA.task04.java.demo;

import part01.chapter02.levelA.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers == null || numbers.length < 1) {
            return;
        }

        int numberWithMinCountOfDifferentDigits = getNumberWithMinCountOfDifferentDigits(numbers);
        System.out.println("Number with min count of different digits = " + numberWithMinCountOfDifferentDigits);
    }

    private static int getNumberWithMinCountOfDifferentDigits(int[] numbers) {
        int minCountOfDifferentNumbers = 11;

        int result = numbers[0];
        for (int number : numbers) {
            int countOfDigits = getCountOfDifferentDigits(number);
            if (countOfDigits < minCountOfDifferentNumbers) {
                minCountOfDifferentNumbers = countOfDigits;
                result = number;
            }
        }
        return result;
    }

    private static int getCountOfDifferentDigits(int number) {
        byte[] countOfDigit = new byte[10];
        char[] digitsOfNumber = String.valueOf(Math.abs(number)).toCharArray();
        for (char digit : digitsOfNumber) {
            int index = Integer.parseInt(String.valueOf(digit));
            countOfDigit[index]++;
        }

        int result = 0;
        for (int count : countOfDigit) {
            if (count > 0) {
                result++;
            }
        }
        return result;
    }
}