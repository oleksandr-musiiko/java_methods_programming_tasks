package part01.chapter02.levelC.task16.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result square matrix with sorted rows by sum of elements:");
        MatrixPrinter.printMatrix(sortRowsBySumOfElements(squareMatrix));
    }

    private static double[][] sortRowsBySumOfElements(double[][] matrix) {
        double[][] order = new double[matrix.length][2];
        for (int i = 0; i < order.length; i++) {
            order[i][0] = i;
            order[i][1] = sumOfElementOfRow(matrix[i]);
        }
        for (int out = order.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (order[in][1] > order[in + 1][1]) {
                    double[] temp = order[in];
                    order[in] = order[in + 1];
                    order[in + 1] = temp;
                }
            }
        }

        double[][] result = new double[matrix.length][];
        for (int resultRowIndex = 0; resultRowIndex < matrix.length; resultRowIndex++) {
            int rowIndexFromMatrix = (int) order[resultRowIndex][0];
            result[resultRowIndex] = matrix[rowIndexFromMatrix];
        }
        return result;
    }

    private static double sumOfElementOfRow(double[] row) {
        double result = 0;
        for (double number : row) {
            result += number;
        }
        return result;
    }
}