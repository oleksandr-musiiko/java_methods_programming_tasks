package part01.chapter02.levelC.task12.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Min element = " + getMinElement(squareMatrix));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input row coordinate:");
        int rowIndex = scanner.nextInt();
        System.out.println("Please, input column coordinate:");
        int columnIndex = scanner.nextInt();

        System.out.println("Result:");
        MatrixPrinter.printMatrix(turnMinElementToCoordinates(squareMatrix, rowIndex, columnIndex));
    }

    private static double[][] turnMinElementToCoordinates(double[][] squareMatrix, int rowIndex, int columnIndex) {
        int[] coordinatesOfMinElement = getCoordinatesOfMinElement(squareMatrix);

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);

        int shiftByRow = rowIndex - coordinatesOfMinElement[0];
        if (shiftByRow > 0) {
            result = shiftMatrixUp(result, shiftByRow);
        } else {
            result = shiftMatrixDown(result, shiftByRow);
        }
        int shiftByColumn = columnIndex - coordinatesOfMinElement[1];
        if (shiftByColumn > 0) {
            result = shiftMatrixLeft(result, shiftByColumn);
        } else {
            result = shiftMatrixRight(result, shiftByColumn);
        }

        return result;
    }

    private static double[][] shiftMatrixLeft(double[][] squareMatrix, int k) {
        return shiftMatrixRight(squareMatrix, -(k));
    }

    private static double[][] shiftMatrixRight(double[][] squareMatrix, int k) {
        final int N = squareMatrix.length;

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            double[] modifiedRow = shiftToRight(squareMatrix[rowIndex], k);
            result[rowIndex] = modifiedRow;
        }
        return result;
    }

    private static double[][] shiftMatrixDown(double[][] squareMatrix, int k) {
        return shiftMatrixUp(squareMatrix, -(k));
    }

    private static double[][] shiftMatrixUp(double[][] squareMatrix, int k) {
        final int N = squareMatrix.length;

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int columnIndex = 0; columnIndex < N; columnIndex++) {
            double[] currentColumn = new double[N];
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                currentColumn[rowIndex] = squareMatrix[rowIndex][columnIndex];
            }

            double[] modifiedColumn = shiftToLeft(currentColumn, k);
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                result[rowIndex][columnIndex] = modifiedColumn[rowIndex];
            }
        }
        return result;
    }

    private static double[] shiftToLeft(double[] array, int k) {
        if (k < 0) {
            return shiftToRight(array, -(k));
        }
        int absoluteShift = k % array.length;

        double[] result = new double[array.length];
        for (int i = 0; i < result.length; i++) {
            int indexOfArray = i < array.length - absoluteShift ? i + absoluteShift : i - (array.length - absoluteShift);
            result[i] = array[indexOfArray];
        }
        return result;
    }

    private static double[] shiftToRight(double[] array, int k) {
        if (k < 0) {
            return shiftToLeft(array, -(k));
        }
        int absoluteShift = k % array.length;

        double[] result = new double[array.length];
        for (int i = result.length - 1; i >= 0; i--) {
            int indexOfArray = i >= absoluteShift ? i - absoluteShift : (i + array.length) - absoluteShift;
            result[i] = array[indexOfArray];
        }
        return result;
    }

    private static int[] getCoordinatesOfMinElement(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double minElement = getMinElement(squareMatrix);
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                if (squareMatrix[rowIndex][columnIndex] == minElement) {
                    return new int[]{rowIndex, columnIndex};
                }
            }
        }
        throw new RuntimeException();
    }

    private static double getMinElement(double[][] squareMatrix) {
        double result = Double.MAX_VALUE;
        for (double[] row : squareMatrix) {
            for (double number : row) {
                result = Math.min(result, number);
            }
        }
        return result;
    }
}
