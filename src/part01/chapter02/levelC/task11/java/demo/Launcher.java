package part01.chapter02.levelC.task11.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Matrix with removed rows and columns with all zero elements:");
        MatrixPrinter.printMatrix(removeRowsAndColumnsWithMaxElement(squareMatrix));
    }

    private static double[][] removeRowsAndColumnsWithMaxElement(double[][] squareMatrix) {
        int[] rowsWithAllZeroElements = getRowsAllZeroElements(squareMatrix);
        int[] columnsWithAllZeroElements = getColumnsAllZeroElements(squareMatrix);
        return removeColumns(
                removeRows(squareMatrix, rowsWithAllZeroElements),
                columnsWithAllZeroElements
        );
    }

    private static double[][] removeColumns(double[][] matrix, int[] columnsForRemove) {
        if (columnsForRemove.length == 0) {
            return matrix;
        }
        int step = 0;
        int resultColumnsLength = matrix[0].length - columnsForRemove.length;

        double[][] result = new double[matrix.length][resultColumnsLength];
        for (int matrixColumnIndex = 0; matrixColumnIndex < matrix[0].length; matrixColumnIndex++) {
            if (step < columnsForRemove.length && matrixColumnIndex == columnsForRemove[step]) {
                step++;
                continue;
            }
            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                result[rowIndex][matrixColumnIndex - step] = matrix[rowIndex][matrixColumnIndex];
            }
        }
        return result;
    }

    private static double[][] removeRows(double[][] matrix, int[] rowsForRemove) {
        final int MATRIX_COUNT_OF_ROWS = matrix.length;
        if (rowsForRemove.length == 0) {
            return matrix;
        }
        int step = 0;
        int resultRowLength = MATRIX_COUNT_OF_ROWS - rowsForRemove.length;

        double[][] result = new double[resultRowLength][MATRIX_COUNT_OF_ROWS];
        for (int matrixRowIndex = 0; matrixRowIndex < MATRIX_COUNT_OF_ROWS; matrixRowIndex++) {
            if (step < rowsForRemove.length && matrixRowIndex == rowsForRemove[step]) {
                step++;
                continue;
            }
            result[matrixRowIndex - step] = matrix[matrixRowIndex];

        }
        return result;
    }

    private static int[] getRowsAllZeroElements(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        int[] result = new int[0];
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            boolean isAllRowZero = true;
            for (double number : squareMatrix[rowIndex]) {
                if (number != 0) {
                    isAllRowZero = false;
                    break;
                }
            }

            if (isAllRowZero) {
                result = addValueToIntArray(result, rowIndex);
            }
        }
        return result;
    }

    private static int[] getColumnsAllZeroElements(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        int[] result = new int[0];
        for (int columnIndex = 0; columnIndex < N; columnIndex++) {
            boolean isAllColumnZero = true;
            for (double[] row : squareMatrix) {
                if (row[columnIndex] != 0) {
                    isAllColumnZero = false;
                    break;
                }
            }

            if (isAllColumnZero) {
                result = addValueToIntArray(result, columnIndex);
            }
        }
        return result;
    }

    private static int[] addValueToIntArray(int[] array, int value) {
        int[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = value;
        return result;
    }
}