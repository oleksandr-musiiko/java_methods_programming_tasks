package part01.chapter02.levelC.task08.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Determinate of matrix = " + obtainDeterminantOfSquareMatrix(squareMatrix));
    }

    private static double obtainDeterminantOfSquareMatrix(double[][] squareMatrix) {
        if (squareMatrix.length == 2) {
            return obtainDeterminantMinSquareMatrix(squareMatrix);
        } else {
            final int ROW_INDEX = 0;

            double result = 0;
            for (int columnIndex = 0; columnIndex < squareMatrix.length; columnIndex++) {
                double determinantOfMinor = obtainDeterminantOfSquareMatrix(obtainMinorOfMatrix(squareMatrix, ROW_INDEX, columnIndex));
                if (columnIndex % 2 == 0) {
                    result += squareMatrix[ROW_INDEX][columnIndex] * determinantOfMinor;
                } else {
                    result -= squareMatrix[ROW_INDEX][columnIndex] * determinantOfMinor;
                }
            }
            return result;
        }
    }

    private static double[][] obtainMinorOfMatrix(double[][] squareMatrix, int rowIndexOfElement, int columnIndexOfElement) {
        if (squareMatrix.length < 3) {
            throw new IllegalArgumentException();
        }
        int newLength = squareMatrix.length - 1;

        double[][] result = new double[newLength][newLength];
        for (int minorRowIndex = 0; minorRowIndex < newLength; minorRowIndex++) {
            for (int minorColumnIndex = 0; minorColumnIndex < newLength; minorColumnIndex++) {
                int indexRowFromSquareMatrix = minorRowIndex < rowIndexOfElement ? minorRowIndex : minorRowIndex + 1;
                int indexColumnFromSquareMatrix = minorColumnIndex < columnIndexOfElement ? minorColumnIndex : minorColumnIndex + 1;
                result[minorRowIndex][minorColumnIndex] = squareMatrix[indexRowFromSquareMatrix][indexColumnFromSquareMatrix];
            }
        }
        return result;
    }

    private static double obtainDeterminantMinSquareMatrix(double[][] minSquareMatrix) {
        if (minSquareMatrix.length != 2) {
            throw new IllegalArgumentException();
        }
        return minSquareMatrix[0][0] * minSquareMatrix[1][1] - minSquareMatrix[0][1] * minSquareMatrix[1][0];
    }
}