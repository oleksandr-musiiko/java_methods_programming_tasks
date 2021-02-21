package part01.chapter01.levelB.task07.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        System.out.println("NOD = " + nOD(numbers));
        System.out.println("NOK = " + nOK(numbers));
    }

    private static int nOD(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 = number1 % number2;
            } else {
                number2 = number2 % number1;
            }
        }
        return number1 + number2;
    }

    private static int nOD(int[] numbers) {
        switch (numbers.length) {
            case 0:
                return 0;
            case 1:
                return numbers[0];
            default: {
                int result = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    result = nOD(result, numbers[i]);
                }
                return result;
            }
        }
    }

    private static int nOK(int number1, int number2) {
        return number1 * number2 / nOD(number1, number2);
    }

    private static int nOK(int[] numbers) {
        switch (numbers.length) {
            case 0:
                return 0;
            case 1:
                return numbers[0];
            default: {
                int result = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    result = nOK(result, numbers[i]);
                }
                return result;
            }
        }
    }
}