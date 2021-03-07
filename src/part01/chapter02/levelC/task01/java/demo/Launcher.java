package part01.chapter02.levelC.task01.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;
import part01.chapter02.levelC.task01.java.util.TimesValueInArrayCounter;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Int k (index from 0 to N)");
        int k = scanner.nextInt();
        if (k >= squareMatrix.length || k < 0) {
            System.err.println("Incorrect k");
            return;
        }

        System.out.println("'1' - for sort columns, '2' - for sort rows");
        switch (scanner.next()) {
            case "1": {
                System.out.println("Matrix with sorted columns:");
                MatrixPrinter.printMatrix(sortColumnsByKRow(squareMatrix, k));
                break;
            }
            case "2": {
                System.out.println("Matrix with sorted rows:");
                MatrixPrinter.printMatrix(sortRowsByKColumn(squareMatrix, k));
                break;
            }
            default: {
                System.err.println("Unsupported option");
            }
        }
    }

    private static double[][] sortColumnsByKRow(double[][] squareMatrix, int k) {
        int[] order = getOrder(squareMatrix[k]);
        final int N = squareMatrix.length;

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int columnIndex = 0; columnIndex < N; columnIndex++) {
            double[] columnArray = new double[N];
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                columnArray[rowIndex] = squareMatrix[rowIndex][columnIndex];
            }

            double[] resultColumn = sortArrayInOrder(columnArray, order);
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                result[rowIndex][columnIndex] = resultColumn[rowIndex];
            }
        }
        return result;
    }

    private static double[][] sortRowsByKColumn(double[][] squareMatrix, int k) {
        final int N = squareMatrix.length;

        double[] kColumn = new double[N];
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            kColumn[rowIndex] = squareMatrix[rowIndex][k];
        }
        int[] order = getOrder(kColumn);

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            double[] row = squareMatrix[rowIndex];
            double[] resultRow = sortArrayInOrder(row, order);
            result[rowIndex] = resultRow;
        }
        return result;
    }

    private static double[] sortArrayInOrder(double[] arrayForSort, int[] order) {
        double[] ascendingSortedArray = sortArray(arrayForSort);

        double[] result = new double[order.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = ascendingSortedArray[order[i]];
        }
        return result;
    }

    private static int[] getOrder(double[] array) {
        double[] sortedArray = sortArray(array);
        double[][] remainingTimesOfNumbers = TimesValueInArrayCounter.obtainTimesInArrayValueAndCount(array);

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            double number = array[i];
            int times = TimesValueInArrayCounter.getTimes(remainingTimesOfNumbers, number);
            remainingTimesOfNumbers = TimesValueInArrayCounter.removeTimeFromTimesArray(remainingTimesOfNumbers, number);
            result[i] = firstIndexOf(sortedArray, number) + times - 1;
        }
        return result;
    }

    private static int firstIndexOf(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static double[] sortArray(double[] array) {
        double[] result = array.clone();
        for (int out = result.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (result[in] < result[in + 1]) {
                    double temp = result[in];
                    result[in] = result[in + 1];
                    result[in + 1] = temp;
                }
            }
        }
        return result;
    }
}