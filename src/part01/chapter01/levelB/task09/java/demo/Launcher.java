package part01.chapter01.levelB.task09.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = (new ConsoleReader().getArrayOfNumbersFromConsole());
        int[] sortedNumbersInAscendingOrder = sortInAscendingOrder(numbers);
        System.out.println("ascending order:");
        for (int number :
                sortedNumbersInAscendingOrder) {
            System.out.print(number + "\t");
        }
        System.out.println();
        int[] sortedNumbersInDescendingOrder = sortInDescendingOrder(numbers);
        System.out.println("descending order:");
        for (int number :
                sortedNumbersInDescendingOrder) {
            System.out.print(number + "\t");
        }
    }

    private static int[] sortInAscendingOrder(int[] numbersForSort) {
        for (int out = numbersForSort.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (numbersForSort[in] > numbersForSort[in + 1]) {
                    int temp = numbersForSort[in];
                    numbersForSort[in] = numbersForSort[in + 1];
                    numbersForSort[in + 1] = temp;
                }
            }
        }
        return numbersForSort;
    }

    private static int[] sortInDescendingOrder(int[] numbersForSort) {
        for (int out = numbersForSort.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (numbersForSort[in] < numbersForSort[in + 1]) {
                    int temp = numbersForSort[in];
                    numbersForSort[in] = numbersForSort[in + 1];
                    numbersForSort[in + 1] = temp;
                }
            }
        }
        return numbersForSort;
    }
}