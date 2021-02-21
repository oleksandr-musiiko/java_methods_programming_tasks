package part01.chapter01.levelB.task02.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int number :
                numbers) {
            maxNumber = Math.max(number, maxNumber);
            minNumber = Math.min(number, minNumber);
        }
        System.out.println("Max number = " + maxNumber + ",\tmin number = " + minNumber);
    }

}