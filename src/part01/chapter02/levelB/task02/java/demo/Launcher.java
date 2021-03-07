package part01.chapter02.levelB.task02.java.demo;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Int k-value");
        int k = scanner.nextInt();

        int[][] matrix = getSquareMatrixFromOneToK(k);
        System.out.println("Matrix from 1 to K:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int number : row) {
                if (number == 0) {
                    System.out.print("_" + "\t");
                } else {
                    System.out.print(number + "\t");
                }
            }
            System.out.println();
        }
    }

    private static int[][] getSquareMatrixFromOneToK(int k) {
        double sqrtK = Math.sqrt(k);
        int n = (int) (sqrtK % 1 == 0 ? sqrtK : Math.ceil(sqrtK));

        int[][] result = new int[n][n];
        int lastIndex = n - 1;
        int rowIndex = 0;
        int indexInRow = 0;
        for (int i = 1; i <= k; i++) {
            result[rowIndex][indexInRow] = i;
            if (indexInRow == lastIndex) {
                rowIndex++;
                indexInRow = 0;
            } else {
                indexInRow++;
            }
        }
        return result;
    }

}