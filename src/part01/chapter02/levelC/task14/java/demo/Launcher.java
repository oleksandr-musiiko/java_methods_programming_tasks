package part01.chapter02.levelC.task14.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result matrix with rounded elements");
        MatrixPrinter.printMatrix(roundElementsInMatrix(squareMatrix));
    }

    private static long[][] roundElementsInMatrix(double[][] matrix) {
        long[][] result = new long[matrix.length][];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            result[rowIndex] = new long[matrix[rowIndex].length];
            for (int columnIndex = 0; columnIndex < result[rowIndex].length; columnIndex++) {
                result[rowIndex][columnIndex] = Math.round(matrix[rowIndex][columnIndex]);
            }
        }
        return result;
    }
}