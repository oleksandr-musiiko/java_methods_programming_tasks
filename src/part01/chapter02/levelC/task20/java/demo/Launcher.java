package part01.chapter02.levelC.task20.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result matrix where diagonal filled with maximum elements from top to bottom:");
        MatrixPrinter.printMatrix(fillTheDiagonalWithMaximumFromTopToBottom(squareMatrix));
    }

    private static double[][] fillTheDiagonalWithMaximumFromTopToBottom(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        for (int indexOfDiagonal = 0; indexOfDiagonal < N; indexOfDiagonal++) {
            int maximumRemainingRowIndex = indexOfDiagonal;
            int maximumRemainingColumnIndex = indexOfDiagonal;

            for (int rowIndex = 0; rowIndex < N; rowIndex++) {
                for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                    if (rowIndex == columnIndex && rowIndex < indexOfDiagonal) {
                        continue;
                    }
                    if (result[rowIndex][columnIndex] > result[maximumRemainingRowIndex][maximumRemainingColumnIndex]) {
                        maximumRemainingRowIndex = rowIndex;
                        maximumRemainingColumnIndex = columnIndex;
                    }
                }
            }
            result = swap(
                    result,
                    maximumRemainingRowIndex, maximumRemainingColumnIndex,
                    indexOfDiagonal, indexOfDiagonal
            );
        }
        return result;
    }

    private static double[][] swap(
            double[][] squareMatrix,
            int fromRowIndex, int fromColumnIndex,
            int toRowIndex, int toColumnIndex) {
        double[][] result = MatrixCloner.cloneMatrix(squareMatrix);
        double temp = result[fromRowIndex][fromColumnIndex];
        result[fromRowIndex][fromColumnIndex] = result[toRowIndex][toColumnIndex];
        result[toColumnIndex][toColumnIndex] = temp;
        return result;
    }
}