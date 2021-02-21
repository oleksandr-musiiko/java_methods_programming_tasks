package part01.chapter01.levelB.task13.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        System.out.println("Palindromic numbers:");
        for (int number : numbers) {
            if (isPalindromicNumber(number)) {
                System.out.print(number + "\t");
            }
        }
    }

    private static boolean isPalindromicNumber(int number) {
        int[] leftOrderDigits = getDigitsOfNumberFromRightToLeft(number);
        int[] rightOrderDigits = reverseIntArray(leftOrderDigits);
        for (int i = 0; i < leftOrderDigits.length; i++) {
            if (leftOrderDigits[i] != rightOrderDigits[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigitsOfNumberFromRightToLeft(int number) {
        int[] result = new int[0];
        while (number >= 1) {
            int digit = number % 10;
            result = addNumberToIntArray(result, digit);
            number /= 10;
        }
        return result;
    }

    private static int[] addNumberToIntArray(int[] array, int numberForAdd) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[result.length - 1] = numberForAdd;
        return result;
    }

    private static int[] reverseIntArray(int[] arrayForReverse) {
        int[] result = new int[arrayForReverse.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayForReverse[result.length - 1 - i];
        }
        return result;
    }

}