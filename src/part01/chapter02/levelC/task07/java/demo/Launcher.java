package part01.chapter02.levelC.task07.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCloner;
import part01.chapter02.levelC.matrix.java.MatrixCreator;
import part01.chapter02.levelC.matrix.java.MatrixPrinter;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Turn counterclockwise. Please, input times to turn. For example:\n"
                + "'1' - 90 degrees, '2' - 180 degrees, '3' - 270 degrees");
        int timesToTurn = new Scanner(System.in).nextInt();

        double[][] resultSquareMatrix = MatrixCloner.cloneMatrix(squareMatrix);
        for (int i = 0; i < timesToTurn; i++) {
            resultSquareMatrix = turn90DegreesCounterclockwise(resultSquareMatrix);
        }
        MatrixPrinter.printMatrix(resultSquareMatrix);
    }

    private static double[][] turn90DegreesCounterclockwise(double[][] squareMatrix) {
        final int N = squareMatrix.length;
        int lastIndex = N - 1;

        double[][] result = new double[N][N];
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                result[rowIndex][columnIndex] = squareMatrix[columnIndex][lastIndex - rowIndex];
            }
        }
        return result;
    }
}