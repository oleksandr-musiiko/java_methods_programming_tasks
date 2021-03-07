package part01.chapter02.levelB.task01.java.demo;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the k-value");
        double k = Double.parseDouble(scanner.next());
        System.out.println("Please input the Int n");
        int n = scanner.nextInt();
        System.out.println("Please input the Int n");
        int m = scanner.nextInt();

        System.out.format("For k = %f, n = %d, m = %d:\n", k, n, m);
        System.out.println("(n,m) = " + isInOutMUntilM(k, n, m));
        System.out.println("[n,m] = " + isInFromNToM(k, n, m));
        System.out.println("(n,m] = " + isInOutNToM(k, n, m));
        System.out.println("[n,m) = " + isInFromNUntilM(k, n, m));
    }

    private static boolean isInOutMUntilM(double number, int n, int m) {
        return number > n && number < m;
    }

    private static boolean isInFromNToM(double number, int n, int m) {
        return number >= n && number <= m;
    }

    private static boolean isInFromNUntilM(double number, int n, int m) {
        return number >= n && number < m;
    }

    private static boolean isInOutNToM(double number, int n, int m) {
        return number > n && number <= m;
    }

}
