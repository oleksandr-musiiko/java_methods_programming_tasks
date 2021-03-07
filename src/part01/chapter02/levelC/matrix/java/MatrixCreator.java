package part01.chapter02.levelC.matrix.java;

import java.util.Random;
import java.util.Scanner;

public class MatrixCreator {

    public double[][] getSquareMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input N-value for matrix N*N, N should be equals or more 1");
        final int N = scanner.nextInt();
        if (N < 1) {
            System.out.println("Incorrect N: N should be equals or more 1");
            return getSquareMatrix();
        }

        double[][] result = new double[N][N];
        for (int indexRow = 0; indexRow < N; indexRow++) {
            for (int indexElementInRow = 0; indexElementInRow < N; indexElementInRow++) {
                result[indexRow][indexElementInRow] = getRandomDoubleInRange(-N, N);
            }
        }

        printSquareMatrix(result);
        return result;
    }

    private void printSquareMatrix(double[][] squareMatrix) {
        System.out.println("Matrix generated:");
        MatrixPrinter.printMatrix(squareMatrix);
    }

    private double getRandomDoubleInRange(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }
}