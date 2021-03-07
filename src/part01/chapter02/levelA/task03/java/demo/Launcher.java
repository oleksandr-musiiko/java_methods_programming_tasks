package part01.chapter02.levelA.task03.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();

        int averageLength = getAverageNumberLength(numbers);
        System.out.println("Average length = " + averageLength);

        System.out.println("More lengths from average:");
        for (int number : numbers) {
            if (String.valueOf(number).length() > averageLength) {
                System.out.print(number + "\t");
            }
        }
        System.out.println();
        System.out.println("Less lengths from average:");
        for (int number : numbers) {
            if (String.valueOf(number).length() < averageLength) {
                System.out.print(number + "\t");
            }
        }
    }

    private static int getAverageNumberLength(int[] numbers) {
        int[][] matrixWithLengthAndCount = new int[0][2];
        for (int number : numbers) {
            int length = String.valueOf(number).length();
            if (containsNumberInMatrix(matrixWithLengthAndCount, length)) {
                int indexOfLength = indexLengthNumberOf(matrixWithLengthAndCount, length);
                matrixWithLengthAndCount[indexOfLength][1]++;
            } else {
                matrixWithLengthAndCount = addLengthToMatrixValueAndCount(matrixWithLengthAndCount, length);
            }
        }
        int arithmeticMeanOfLengthOfNumbers = numbers.length / matrixWithLengthAndCount.length;
        int minDistanceToMedian = Integer.MAX_VALUE;

        int result = 0;
        for (int[] row : matrixWithLengthAndCount) {
            int count = row[1];
            if (arithmeticMeanOfLengthOfNumbers - count < minDistanceToMedian) {
                minDistanceToMedian = arithmeticMeanOfLengthOfNumbers - count;
                result = count;
            }
        }
        return result;
    }

    private static int indexLengthNumberOf(int[][] matrix, int lengthNumber) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == lengthNumber) {
                return i;
            }
        }
        return -1;
    }

    private static boolean containsNumberInMatrix(int[][] matrix, int value) {
        return indexLengthNumberOf(matrix, value) != -1;
    }

    private static int[][] addLengthToMatrixValueAndCount(int[][] matrix, int lengthOfNumber) {
        if (matrix.length == 0) {
            return new int[][]{new int[]{lengthOfNumber, 1}};
        }

        int[][] result = new int[matrix.length + 1][2];
        System.arraycopy(matrix, 0, result, 0, matrix.length);
        result[result.length - 1] = new int[]{lengthOfNumber, 1};
        return result;
    }
}