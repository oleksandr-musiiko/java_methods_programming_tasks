package part01.chapter01.levelB.task16.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        for (int number : numbers) {
            if (number >= 0) {
                System.out.format("Pascal triangle for %d:\n", number);
                int[][] pascalTriangle = getPascalTriangle(number);
                for (int[] row : pascalTriangle) {
                    for (int value : row) {
                        if (value == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.print(value);
                        }
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Numbers satisfying the condition were not found");
    }

    public static int[][] getPascalTriangle(int number) {
        int countOfRows = number + 1;
        if (countOfRows == 1) {
            return new int[][]{new int[]{1}};
        }
        int widthInNumbers = (countOfRows * 2) - 1;
        int[][] result = new int[countOfRows][widthInNumbers];
        for (int i = 0; i < widthInNumbers; i++) {
            if (i == widthInNumbers / 2) {
                result[0][i] = 1;
            } else {
                result[0][i] = 0;
            }
        }
        int lastIndex = widthInNumbers - 1;
        for (int rowIndex = 1; rowIndex < countOfRows; rowIndex++) {
            for (int i = 0; i < widthInNumbers; i++) {
                int leftIndex = i == 0 ? lastIndex : i - 1;
                int rightIndex = i == lastIndex ? 0 : i + 1;
                result[rowIndex][i] = result[rowIndex - 1][leftIndex] + result[rowIndex - 1][rightIndex];
            }
        }
        return result;
    }
}