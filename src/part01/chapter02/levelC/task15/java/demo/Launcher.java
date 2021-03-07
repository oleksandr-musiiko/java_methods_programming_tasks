package part01.chapter02.levelC.task15.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Count of saddle points = " + countOfSaddlePoints(squareMatrix));
    }

    private static int countOfSaddlePoints(double[][] squareMatrix) {
        final int N = squareMatrix.length;
        double[] minElementsInEveryRow = getMinElementsInEveryRow(squareMatrix);
        double[] maxElementsInEveryColumn = getMaxElementsInEveryColumn(squareMatrix);

        int result = 0;
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                double elementOfSquareMatrix = squareMatrix[rowIndex][columnIndex];
                if (elementOfSquareMatrix == minElementsInEveryRow[rowIndex] &&
                        elementOfSquareMatrix == maxElementsInEveryColumn[columnIndex]) {
                    result++;
                }
            }
        }
        return result;
    }

    private static double[] getMinElementsInEveryRow(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[] result = new double[N];
        for (int rowIndex = 0; rowIndex < result.length; rowIndex++) {
            result[rowIndex] = getMinInRow(squareMatrix, rowIndex);
        }
        return result;
    }

    private static double[] getMaxElementsInEveryColumn(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[] result = new double[N];
        for (int columnIndex = 0; columnIndex < result.length; columnIndex++) {
            result[columnIndex] = getMaxInColumn(squareMatrix, columnIndex);
        }
        return result;
    }

    private static double getMinInRow(double[][] squareMatrix, int rowIndex) {
        double result = Double.MAX_VALUE;
        for (double number : squareMatrix[rowIndex]) {
            result = Math.min(result, number);
        }
        return result;
    }

    private static double getMaxInColumn(double[][] squareMatrix, int columnIndex) {
        double result = Double.MIN_VALUE;
        for (int rowIndex = 0; rowIndex < squareMatrix.length; rowIndex++) {
            result = Math.max(result, squareMatrix[rowIndex][columnIndex]);
        }
        return result;
    }
}