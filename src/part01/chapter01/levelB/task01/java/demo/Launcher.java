package part01.chapter01.levelB.task01.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        for (int number :
                numbers) {
            if (number % 2 == 0) {
                System.out.print(number + "\t");
            }
        }
        System.out.println();
        for (int number :
                numbers) {
            if (number % 2 == 1) {
                System.out.print(number + "\t");
            }
        }
    }

}