package part01.chapter02.levelC.task04.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Sum of matrix elements from first positive to second in all rows:");
        System.out.println(sumOfMatrixElementsFromFirstPositiveToSecondInRow(squareMatrix));
    }

    private static double sumOfMatrixElementsFromFirstPositiveToSecondInRow(double[][] matrix) {
        double result = 0;
        for (double[] row : matrix) {
            result += sumOfElementsFromFirstPositiveToSecond(row);
        }
        return result;
    }

    private static double sumOfElementsFromFirstPositiveToSecond(double[] row) {
        int[] indexes = getIndexesOfPositiveNumbers(row);
        if (indexes.length < 2) {
            return 0;
        }

        int fromRowIndex = indexes[0];
        int untilRowIndex = indexes[1];

        double result = 0;
        for (int i = fromRowIndex + 1; i < untilRowIndex; i++) {
            result += row[i];
        }
        return result;
    }

    private static int[] getIndexesOfPositiveNumbers(double[] row) {
        int countOfPositiveNumbers = 0;
        for (double number : row) {
            if (number >= 0) {
                countOfPositiveNumbers++;
            }
        }
        if (countOfPositiveNumbers == 0) {
            return new int[0];
        }

        int[] result = new int[countOfPositiveNumbers];
        int indexOfResult = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] >= 0) {
                result[indexOfResult++] = i;
            }
        }
        return result;
    }
}