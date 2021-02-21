package part01.chapter01.levelB.task14.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        if (numbers.length < 1) {
            return;
        }
        System.out.println("Numbers that are equal to the half-sum of neighboring elements:");
        int lastIndex = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int leftIndex = i == 0 ? lastIndex : i - 1;
            int rightIndex = i == lastIndex ? 0 : i + 1;
            if (numbers[i] == (numbers[leftIndex] + numbers[rightIndex]) / 2) {
                System.out.print(numbers[i] + "\t");
            }
        }
    }

}