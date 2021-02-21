package part01.chapter01.levelB.task04.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        for (int number:
             numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.print(number + "\t");
            }
        }
    }
}
