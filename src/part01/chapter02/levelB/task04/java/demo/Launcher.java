package part01.chapter02.levelB.task04.java.demo;

import part01.chapter02.levelB.task04.java.model.Months;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please, input the Int number of month (from 1 to 12)");
            int number = scanner.nextInt();

            if (isCorrectNumberOfMonth(number)) {
                System.out.println(getMonthByNumber(number));
            } else {
                System.out.println("Number is incorrect");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static String getMonthByNumber(int number) {
        switch (number) {
            case 1: return Months.JANUARY.toString();
            case 2: return Months.FEBRUARY.toString();
            case 3: return Months.MARCH.toString();
            case 4: return Months.APRIL.toString();
            case 5: return Months.MAY.toString();
            case 6: return Months.JUNE.toString();
            case 7: return Months.JULY.toString();
            case 8: return Months.AUGUST.toString();
            case 9: return Months.SEPTEMBER.toString();
            case 10: return Months.OCTOBER.toString();
            case 11: return Months.NOVEMBER.toString();
            case 12: return Months.DECEMBER.toString();
            default: throw new IllegalArgumentException("Month with index = " + number + " not found");
        }
    }

    private static boolean isCorrectNumberOfMonth(int number) {
        return number >= 1 && number <= 12;
    }

}