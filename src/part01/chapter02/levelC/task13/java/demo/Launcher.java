package part01.chapter02.levelC.task13.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result square matrix, where zero elements shift to end in every row");
        MatrixPrinter.printMatrix(shiftZeroElementsToEndOfRows(squareMatrix));
    }

    private static double[][] shiftZeroElementsToEndOfRows(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int outColumnIndex = N - 1; outColumnIndex >= 0; outColumnIndex--) {
                for (int inColumnIndex = 0; inColumnIndex < outColumnIndex; inColumnIndex++) {
                    if (result[rowIndex][inColumnIndex] == 0) {
                        result[rowIndex][inColumnIndex] = result[rowIndex][inColumnIndex + 1];
                        result[rowIndex][inColumnIndex + 1] = 0;
                    }
                }
            }
        }
        return result;
    }

}