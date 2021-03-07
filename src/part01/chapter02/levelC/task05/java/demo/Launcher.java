package part01.chapter02.levelC.task05.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Transposed matrix:");
        MatrixPrinter.printMatrix(transposeSquareMatrix(squareMatrix));
    }

    private static double[][] transposeSquareMatrix(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[][] result = new double[N][N];
        for (int columnIndex = 0; columnIndex < N; columnIndex++) {
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                result[rowIndex][columnIndex] = squareMatrix[columnIndex][rowIndex];
            }
        }
        return result;
    }
}