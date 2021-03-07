package part01.chapter02.levelC.task02.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input int K - count of shifting");
        int k = scanner.nextInt();

        System.out.println("Shift:\n'1' - right, '2' - left, '3' - up, '4' - down");
        switch (scanner.next()) {
            case "1": {
                System.out.println("k = " + k + " , right shifting");
                MatrixPrinter.printMatrix(shiftMatrixRight(squareMatrix, k));
                break;
            }
            case "2": {
                System.out.println("k = " + k + " , left shifting");
                MatrixPrinter.printMatrix(shiftMatrixLeft(squareMatrix, k));
                break;
            }
            case "3": {
                System.out.println("k = " + k + " , up shifting");
                MatrixPrinter.printMatrix(shiftMatrixUp(squareMatrix, k));
                break;
            }
            case "4": {
                System.out.println("k = " + k + " , down shifting");
                MatrixPrinter.printMatrix(shiftMatrixDown(squareMatrix, k));
                break;
            }
            default: {
                System.out.println("Incorrect option");
            }
        }
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
}