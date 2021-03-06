package part01.chapter02.levelC.task17.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Count of local minimum elements = " + obtainCountOfLocalMinimumElements(squareMatrix));
    }

    private static int obtainCountOfLocalMinimumElements(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        int result = 0;
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                if (isElementLocalMinimum(squareMatrix, rowIndex, columnIndex)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isElementLocalMinimum(double[][] squareMatrix, int rowIndexOfElement, int columnIndexOfElement) {
        final int N = squareMatrix.length;
        final double ELEMENT = squareMatrix[rowIndexOfElement][columnIndexOfElement];

        int startRowIndex = rowIndexOfElement == 0 ? 0 : rowIndexOfElement - 1;
        int finishRowIndex = rowIndexOfElement == N - 1 ? N - 1 : rowIndexOfElement + 1;
        int startColumnIndex = columnIndexOfElement == 0 ? columnIndexOfElement : columnIndexOfElement - 1;
        int finishColumnIndex = columnIndexOfElement == N - 1 ? N - 1 : columnIndexOfElement + 1;

        for (int rowIndex = startRowIndex; rowIndex <= finishRowIndex; rowIndex++) {
            for (int columnIndex = startColumnIndex; columnIndex <= finishColumnIndex; columnIndex++) {
                if (rowIndex == rowIndexOfElement && columnIndex == columnIndexOfElement) {
                    continue;
                }
                if (squareMatrix[rowIndex][columnIndex] <= ELEMENT) {
                    return false;
                }
            }
        }
        return true;
    }
}