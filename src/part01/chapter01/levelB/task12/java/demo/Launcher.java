package part01.chapter01.levelB.task12.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        System.out.println("Fibonacci numbers:");
        for (int number:
             numbers) {
            if (isFibonacciNumber(number)) {
                System.out.print(number + "\t");
            }
        }
    }

    private static boolean isFibonacciNumber(int number) {
        double gesselNumberWithPlus = 5 * Math.pow(number, 2) + 4;
        double gesselNumberWithMinus= 5 * Math.pow(number, 2) - 4;
        return isDoubleWhole(Math.sqrt(gesselNumberWithPlus)) || isDoubleWhole(Math.sqrt(gesselNumberWithMinus));
    }

    private static boolean isDoubleWhole(double number) {
        return number % 1 == 0;
    }

}
