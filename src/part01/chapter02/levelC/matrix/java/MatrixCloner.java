package part01.chapter02.levelC.matrix.java;

public class MatrixCloner {

    public static double[][] cloneMatrix(double[][] matrixForClone) {
        double[][] result = new double[matrixForClone.length][];
        for (int rowIndex = 0; rowIndex < result.length; rowIndex++) {
            result[rowIndex] = matrixForClone[rowIndex].clone();
        }
        return result;
    }
}
