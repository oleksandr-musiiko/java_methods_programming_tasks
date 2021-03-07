package part01.chapter02.levelC.task19.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Result square matrix with sorted columns by characteristics:");
        MatrixPrinter.printMatrix(sortColumnsByCharacteristics(squareMatrix));
    }

    private static double[][] sortColumnsByCharacteristics(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        double[][] order = new double[N][2];
        for (int orderIndex = 0; orderIndex < order.length; orderIndex++) {
            order[orderIndex][0] = orderIndex;
            order[orderIndex][1] = obtainCharacteristicOfColumn(squareMatrix, orderIndex);
        }
        for (int outIndex = N - 1; outIndex >= 1; outIndex--) {
            for (int inIndex = 0; inIndex < outIndex; inIndex++) {
                if (order[inIndex][1] > order[inIndex + 1][1]) {
                    double[] temp = order[inIndex];
                    order[inIndex] = order[inIndex + 1];
                    order[inIndex + 1] = temp;
                }
            }
        }

        double[][] result = new double[N][N];
        for (int resultColumnIndex = 0; resultColumnIndex < N; resultColumnIndex++) {
            int columnIndexFromMatrix = (int) order[resultColumnIndex][0];
            for (int resultRowIndex = 0; resultRowIndex < N; resultRowIndex++) {
                result[resultRowIndex][resultColumnIndex] = squareMatrix[resultRowIndex][columnIndexFromMatrix];
            }
        }
        return result;
    }

    private static double obtainCharacteristicOfColumn(double[][] squareMatrix, int columnIndex) {
        double result = 0;
        for (double[] row : squareMatrix) {
            result += Math.abs(row[columnIndex]);
        }
        return result;
    }
}