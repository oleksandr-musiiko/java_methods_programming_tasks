package part01.chapter02.levelA.task02.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();

        int[] sortedArrayByLengthOfNumber = sortNumbersByLength(numbers);
        System.out.println("Ascending order by length:");
        for (int number : sortedArrayByLengthOfNumber) {
            System.out.print(number + "\t");
        }
        System.out.println();
        System.out.println("Descending order by length:");
        for (int i = sortedArrayByLengthOfNumber.length - 1; i>= 0; i--) {
            System.out.print(sortedArrayByLengthOfNumber[i] + "\t");
        }

    }

    private static int[] sortNumbersByLength(int[] numbers) {
        int[] result = numbers.clone();
        for (int out = result.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (String.valueOf(result[in]).length() > String.valueOf(result[in + 1]).length()) {
                    int temp = result[in];
                    result[in] = result[in + 1];
                    result[in + 1] = temp;
                }
            }
        }
        return result;
    }
}