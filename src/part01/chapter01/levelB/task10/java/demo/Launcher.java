package part01.chapter01.levelB.task10.java.demo;

import part01.chapter01.levelB.console.java.ConsoleReader;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new ConsoleReader().getArrayOfNumbersFromConsole();
        System.out.println();
        int[] sortedArray = sortInDescendingOrderOfOccurrence(numbers);
        for (int number :
                sortedArray) {
            System.out.print(number + "\t");
        }
    }

    private static int[] sortInDescendingOrderOfOccurrence(int[] numbers) {
        int[] arrayOfDifferenceNumbers = arrayOfDifferentNumbers(numbers);
        Integer[][] matrix = matrixCountOfDifferentNumbersArray(numbers, arrayOfDifferenceNumbers);
        int[] result = new int[numbers.length];
        int resultArrayIndex = 0;
        for (int countMatrixIndex = matrix.length - 1; countMatrixIndex >= 0; countMatrixIndex--) {
            for (int numberMatrixIndex = 0; numberMatrixIndex < matrix[countMatrixIndex].length; numberMatrixIndex++) {
                if (matrix[countMatrixIndex][numberMatrixIndex] == null) {
                    break;
                }
                int numberForSaveToResultArray = matrix[countMatrixIndex][numberMatrixIndex];
                for (int i = 0; i < countMatrixIndex; i++) {
                    result[resultArrayIndex] = numberForSaveToResultArray;
                    resultArrayIndex++;
                }
            }
        }
        return result;
    }

    private static Integer[][] matrixCountOfDifferentNumbersArray(int[] numbers, int[] differentNumbers) {
        Integer[][] result = new Integer[numbers.length][differentNumbers.length];
        for (int unicNumber :
                differentNumbers) {
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (unicNumber == numbers[i]) {
                    count++;
                }
            }
            for (int indexOfUnicNumberForSave = 0; indexOfUnicNumberForSave < differentNumbers.length; indexOfUnicNumberForSave++) {
                if (result[count][indexOfUnicNumberForSave] == null) {
                    result[count][indexOfUnicNumberForSave] = unicNumber;
                    break;
                }
            }
        }
        return result;
    }

    private static int[] arrayOfDifferentNumbers(int[] numbers) {
        Integer[] tempArray = new Integer[numbers.length];
        int differentNumbersSize = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int tempArrayIndex = 0; tempArrayIndex < tempArray.length; tempArrayIndex++) {
                if (tempArray[tempArrayIndex] == null) {
                    tempArray[tempArrayIndex] = number;
                    differentNumbersSize++;
                    break;
                }
                if (tempArray[tempArrayIndex] == number) {
                    break;
                }
            }
        }
        int[] resultArray = new int[differentNumbersSize];
        for (int i = 0; i < differentNumbersSize; i++) {
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }

}