package part01.chapter01.levelB.task15.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers.length < 2) {
            System.out.println("Not enough numbers");
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int number1 = numbers[i];
            int number2 = numbers[i + 1];
            if (number1 >= 0 && number2 >= 1) {
                System.out.format("Decimal period of %d / %d:" + "\n", number1, number2);
                int[] decimalPeriod = getDecimalPeriod(number1, number2);
                for (int digit : decimalPeriod) {
                    System.out.print(digit);
                }
                return;
            }
        }
        System.out.println("Numbers satisfying the condition were not found");
    }

    private static int[] getDecimalPeriod(int firstNumber, int secondNumber) {
        int[] arrayOfDivisionOperations = new int[0];
        int dividend = firstNumber;
        while (true) {
            if (containsOperationInArray(arrayOfDivisionOperations, dividend)) {
                int startIndex = indexOf(arrayOfDivisionOperations, dividend);
                int[] arrayOfDecimalDigits = new int[0];
                for (int i = startIndex; i < arrayOfDivisionOperations.length; i++) {
                    int times = arrayOfDivisionOperations[i] / secondNumber;
                    arrayOfDecimalDigits = addValueToIntArray(arrayOfDecimalDigits, times);
                }
                return arrayOfDecimalDigits;
            } else {
                arrayOfDivisionOperations = addValueToIntArray(arrayOfDivisionOperations, dividend);
            }
            dividend = (dividend % secondNumber) * 10;
        }
    }

    private static boolean containsOperationInArray(int[] array, int value) {
        return indexOf(array, value) != -1;
    }

    private static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int[] addValueToIntArray(int[] array, int valueForAdd) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[result.length - 1] = valueForAdd;
        return result;
    }
}