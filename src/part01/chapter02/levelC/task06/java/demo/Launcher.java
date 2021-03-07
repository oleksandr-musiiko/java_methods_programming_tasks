package part01.chapter02.levelC.task06.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("M-norm = " + obtainMSquareMatrixNorm(squareMatrix));
        System.out.println("L-norm = " + obtainLSquareMatrixNorm(squareMatrix));
        System.out.println("K-norm = " + obtainKSquareMatrixNorm(squareMatrix));
    }

    public static double obtainMSquareMatrixNorm(double[][] squareMatrix) {
        double result = 0;
        for (double[] row : squareMatrix) {
            double sumOfAbsOfElementsInRow = 0;
            for (double number : row) {
                sumOfAbsOfElementsInRow += Math.abs(number);
            }

            result = Math.max(result, sumOfAbsOfElementsInRow);
        }
        return result;
    }

    public static double obtainLSquareMatrixNorm(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double result = 0;
        for (int columnIndex = 0; columnIndex < N; columnIndex++) {
            double sumOfAbsOfElementsInColumn = 0;
            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                sumOfAbsOfElementsInColumn += Math.abs(squareMatrix[rowIndex][columnIndex]);
            }

            result = Math.max(result, sumOfAbsOfElementsInColumn);
        }
        return result;
    }

    public static double obtainKSquareMatrixNorm(double[][] squareMatrix) {
        double sumOfSquaresOfElements = 0;
        for (double[] row : squareMatrix) {
            for (double number : row) {
                sumOfSquaresOfElements += Math.pow(number, 2);
            }
        }
        return Math.sqrt(sumOfSquaresOfElements);
    }
}