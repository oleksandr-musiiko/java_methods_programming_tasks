package part01.chapter02.levelC.matrix.java;

public class MatrixPrinter {

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double number : row) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long number : row) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }
}