package part01.chapter02.levelC.task03.java.demo;

import part01.chapter02.levelC.matrix.java.MatrixCreator;

public class Launcher {

    public static void main(String[] args) {
        double[][] squareMatrix = new MatrixCreator().getSquareMatrix();
        System.out.println("Max count ascending order elements in a row = " + maxCountInAscendingOrder(squareMatrix));
        System.out.println("Max count descending order elements in a row = " + maxCountInDescendingOrder(squareMatrix));
    }

    private static int maxCountInAscendingOrder(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        int maxCount = 0;
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                int countInRow = countInAscendingOrderInRow(squareMatrix, rowIndex, columnIndex);
                int countInColumn = countInAscendingOrderInColumn(squareMatrix, rowIndex, columnIndex);
                int countInLeftDiagonal = countInAscendingOrderInLeftDiagonal(squareMatrix, rowIndex, columnIndex);
                int countInRightDiagonal = countInAscendingOrderInRightDiagonal(squareMatrix, rowIndex, columnIndex);

                int maxCountForElement = maxValue(countInRow, countInColumn, countInLeftDiagonal, countInRightDiagonal);
                maxCount = Math.max(maxCountForElement, maxCount);
            }
        }
        return maxCount;
    }

    private static int maxCountInDescendingOrder(double[][] squareMatrix) {
        final int N = squareMatrix.length;

        int maxCount = 0;
        for (int rowIndex = 0; rowIndex < N; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                int countInRow = countInDescendingOrderInRow(squareMatrix, rowIndex, columnIndex);
                int countInColumn = countInDescendingOrderInColumn(squareMatrix, rowIndex, columnIndex);
                int countInLeftDiagonal = countInDescendingOrderInLeftDiagonal(squareMatrix, rowIndex, columnIndex);
                int countInRightDiagonal = countInDescendingOrderInRightDiagonal(squareMatrix, rowIndex, columnIndex);

                int maxCountForElement = maxValue(countInRow, countInColumn, countInLeftDiagonal, countInRightDiagonal);
                maxCount = Math.max(maxCount, maxCountForElement);
            }
        }
        return maxCount;
    }

    private static int countInAscendingOrderInRightDiagonal(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0 && rowIndex < N - 1) {
            int tmpRowIndex = rowIndex + 1;
            int tmpColumnIndex = columnIndex - 1;

            while (tmpRowIndex < N && tmpColumnIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] <= squareMatrix[tmpRowIndex - 1][tmpColumnIndex + 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex++;
                tmpColumnIndex--;
            }
        }
        if (columnIndex < N - 1 && rowIndex > 0) {
            int tmpRowIndex = rowIndex - 1;
            int tmpColumnIndex = columnIndex + 1;

            while (tmpColumnIndex < N && tmpRowIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] >= squareMatrix[tmpRowIndex + 1][tmpColumnIndex - 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex--;
                tmpColumnIndex++;
            }
        }
        return result;
    }

    private static int countInDescendingOrderInRightDiagonal(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0 && rowIndex < N - 1) {
            int tmpRowIndex = rowIndex + 1;
            int tmpColumnIndex = columnIndex - 1;

            while (tmpRowIndex < N && tmpColumnIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] >= squareMatrix[tmpRowIndex - 1][tmpColumnIndex + 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex++;
                tmpColumnIndex--;
            }
        }
        if (columnIndex < N - 1 && rowIndex > 0) {
            int tmpRowIndex = rowIndex - 1;
            int tmpColumnIndex = columnIndex + 1;

            while (tmpColumnIndex < N && tmpRowIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] <= squareMatrix[tmpRowIndex + 1][tmpColumnIndex - 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex--;
                tmpColumnIndex++;
            }
        }
        return result;
    }

    private static int countInAscendingOrderInLeftDiagonal(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0 && rowIndex > 0) {
            int tmpRowIndex = rowIndex - 1;
            int tmpColumnIndex = columnIndex - 1;

            while (tmpRowIndex >= 0 && tmpColumnIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] <= squareMatrix[tmpRowIndex + 1][tmpColumnIndex + 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex--;
                tmpColumnIndex--;
            }
        }
        if (columnIndex < N - 1 && rowIndex < N - 1) {
            int tmpRowIndex = rowIndex + 1;
            int tmpColumnIndex = columnIndex + 1;

            while (tmpColumnIndex < N && tmpRowIndex < N) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] >= squareMatrix[tmpRowIndex - 1][tmpColumnIndex - 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex++;
                tmpColumnIndex++;
            }
        }
        return result;
    }

    private static int countInDescendingOrderInLeftDiagonal(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0 && rowIndex > 0) {
            int tmpRowIndex = rowIndex - 1;
            int tmpColumnIndex = columnIndex - 1;

            while (tmpRowIndex >= 0 && tmpColumnIndex >= 0) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] >= squareMatrix[tmpRowIndex + 1][tmpColumnIndex + 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex--;
                tmpColumnIndex--;
            }
        }
        if (columnIndex < N - 1 && rowIndex < N - 1) {
            int tmpRowIndex = rowIndex + 1;
            int tmpColumnIndex = columnIndex + 1;

            while (tmpColumnIndex < N && tmpRowIndex < N) {
                if (squareMatrix[tmpRowIndex][tmpColumnIndex] <= squareMatrix[tmpRowIndex - 1][tmpColumnIndex - 1]) {
                    result++;
                } else {
                    break;
                }

                tmpRowIndex++;
                tmpColumnIndex++;
            }
        }
        return result;
    }

    private static int countInAscendingOrderInColumn(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (rowIndex > 0) {
            for (int i = rowIndex - 1; i >= 0; i--) {
                if (squareMatrix[i][columnIndex] <= squareMatrix[i + 1][columnIndex]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        if (rowIndex < N - 1) {
            for (int i = rowIndex + 1; i < N; i++) {
                if (squareMatrix[i][columnIndex] >= squareMatrix[i - 1][columnIndex]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int countInDescendingOrderInColumn(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (rowIndex > 0) {
            for (int i = rowIndex - 1; i >= 0; i--) {
                if (squareMatrix[i][columnIndex] >= squareMatrix[i + 1][columnIndex]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        if (rowIndex < N - 1) {
            for (int i = rowIndex + 1; i < N; i++) {
                if (squareMatrix[i][columnIndex] <= squareMatrix[i - 1][columnIndex]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int countInAscendingOrderInRow(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0) {
            for (int i = columnIndex - 1; i >= 0; i--) {
                if (squareMatrix[rowIndex][i] <= squareMatrix[rowIndex][i + 1]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        if (columnIndex < N - 1) {
            for (int i = columnIndex + 1; i < N; i++) {
                if (squareMatrix[rowIndex][i] > squareMatrix[rowIndex][i - 1]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int countInDescendingOrderInRow(double[][] squareMatrix, int rowIndex, int columnIndex) {
        final int N = squareMatrix.length;

        int result = 1;
        if (columnIndex > 0) {
            for (int i = columnIndex - 1; i >= 0; i--) {
                if (squareMatrix[rowIndex][i] >= squareMatrix[rowIndex][i + 1]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        if (columnIndex < N - 1) {
            for (int i = columnIndex + 1; i < N; i++) {
                if (squareMatrix[rowIndex][i] <= squareMatrix[rowIndex][i - 1]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static int maxValue(int number1, int number2, int number3, int number4) {
        return Math.max(maxValue(number1, number2, number3), number4);
    }

    private static int maxValue(int number1, int number2, int number3) {
        return Math.max(Math.max(number1, number2), number3);
    }
}