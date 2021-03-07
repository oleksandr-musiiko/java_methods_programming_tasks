package part01.chapter02.levelC.task09.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result:");
        MatrixPrinter.printMatrix(subtractArithmeticMeanOfEachRowFromMatrixElements(squareMatrix));
    }

    private static double[][] subtractArithmeticMeanOfEachRowFromMatrixElements(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[][] result = new double[N][N];
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            double arithmeticMeanOfRow = obtainArithmeticMeanOfRow(squareMatrix[rowIndex]);
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                result[rowIndex][columnIndex] = squareMatrix[rowIndex][columnIndex] - arithmeticMeanOfRow;
            }
        }
        return result;
    }

    private static double obtainArithmeticMeanOfRow(double[] row) {
        double sumOfElements = 0;
        for (double number : row) {
            sumOfElements += number;
        }
        return sumOfElements / row.length;
    }
}