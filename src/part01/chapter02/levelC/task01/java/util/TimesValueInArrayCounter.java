package part01.chapter02.levelC.task01.java.util;

import java.util.Arrays;

public class TimesValueInArrayCounter {

    public static double[][] obtainTimesInArrayValueAndCount(double[] array) {
        double[][] result = new double[0][2];
        for (double number : array) {
            result = addTimesToTimesArray(result, number);
        }
        return result;
    }

    public static int getTimes(double[][] timesArray, double number) {
        if (containsInTimesArray(timesArray, number)) {
            return (int) timesArray[indexOfTimesArray(timesArray, number)][1];
        }
        return 0;
    }

    public static double[][] removeTimeFromTimesArray(double[][] timesArray, double number) {
        double[][] result = timesArray.clone();
        if (containsInTimesArray(timesArray, number)) {
            result[indexOfTimesArray(result, number)][1]--;
        }
        return result;
    }

    private static double[][] addTimesToTimesArray(double[][] timesArray, double number) {
        double[][] result;
        if (containsInTimesArray(timesArray, number)) {
            result = timesArray.clone();
            result[indexOfTimesArray(result, number)][1]++;
        } else {
            result = Arrays.copyOf(timesArray, timesArray.length + 1);
            result[result.length - 1] = new double[]{number, 1.0};
        }
        return result;
    }

    private static boolean containsInTimesArray(double[][] timesArray, double number) {
        return indexOfTimesArray(timesArray, number) != -1;
    }

    private static int indexOfTimesArray(double[][] timesArray, double value) {
        for (int i = 0; i < timesArray.length; i++) {
            if (timesArray[i][0] == value) {
                return i;
            }
        }
        return -1;
    }
}