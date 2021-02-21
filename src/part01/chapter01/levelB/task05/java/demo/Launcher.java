package part01.chapter01.levelB.task05.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader()).getArrayOfNumbersFromConsole();
        for (int out = numbers.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (Math.abs(numbers[in]) < Math.abs(numbers[in+1])) {
                    int temp = numbers[in];
                    numbers[in] = numbers[in+1];
                    numbers[in+1] = temp;
                }
            }
        }
        for (int number :
                numbers) {
            System.out.print(number + "\t");
        }
    }

}
