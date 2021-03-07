package part01.chapter02.levelA.task08.java.demo;

import part01.chapter02.levelA.console.java.ConsoleReader;

public class Launcher {

    private static final int NOT_PALINDROMIC_DEFAULT = 10;

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();

        int countOfFounded = 0;
        int firstPalindromicNumber = NOT_PALINDROMIC_DEFAULT;
        for (int number : numbers) {
            if (isPalindromicNumber(number)) {
                countOfFounded++;
                switch (countOfFounded) {
                    case 1: {
                        firstPalindromicNumber = number;
                        break;
                    }
                    case 2: {
                        System.out.println("Second palindromic number = " + number);
                        return;
                    }
                }
            }
        }
        if (firstPalindromicNumber != NOT_PALINDROMIC_DEFAULT) {
            System.out.println("Only one palindromic number = " + firstPalindromicNumber);
        } else {
            System.out.println("Palindromic numbers not found");
        }
    }

    private static boolean isPalindromicNumber(int number) {
        char[] charDigits = Integer.toString(Math.abs(number)).toCharArray();
        int lastIndex = charDigits.length - 1;
        for (int i = 0; i < charDigits.length; i++) {
            if (charDigits[i] != charDigits[lastIndex - i]) {
                return false;
            }
        }
        return true;
    }
}