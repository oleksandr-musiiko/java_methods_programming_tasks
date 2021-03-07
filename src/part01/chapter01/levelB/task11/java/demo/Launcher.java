package part01.chapter01.levelB.task11.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        System.out.println("Happies numbers:");
        for (int number:
             numbers) {
            if (isHappyNumber(number)) {
                System.out.print(number + "\t");
            }
        }
    }

    private static boolean isHappyNumber(int number) {
        int[] visitedTempNumbers = new int[]{number};
        while (true) {
            int sumOfDigitsTemp = sumOfSquaresOfDigits(number);
            if (sumOfDigitsTemp == 1) {
                return true;
            }
            if (isArrayContainsValue(visitedTempNumbers, sumOfDigitsTemp)) {
                return false;
            } else {
                visitedTempNumbers = addToIntArray(visitedTempNumbers, sumOfDigitsTemp);
                number = sumOfDigitsTemp;
            }
        }
    }

    private static int sumOfSquaresOfDigits(int number) {
        int result = 0;
        while (number >= 1) {
            result += Math.pow(number % 10, 2);
            number /= 10;
        }
        return result;
    }

    private static int[] addToIntArray(int[] intArray, int numberForAdd) {
        int[] result = new int[intArray.length + 1];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = intArray[i];
        }
        result[result.length - 1] = numberForAdd;
        return result;
    }

    private static boolean isArrayContainsValue(int[] array, int value) {
        for (int number:
             array) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

}