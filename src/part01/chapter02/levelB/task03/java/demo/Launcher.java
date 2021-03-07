package part01.chapter02.levelB.task03.java.demo;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a * x^2 + b * x + c = 0");
        System.out.println("Please, input a-value != 0");
        double a = Double.parseDouble(scanner.next());
        if (a == 0) {
            main(args);
        }
        System.out.println("Please, input b-value");
        double b = Double.parseDouble(scanner.next());
        System.out.println("Please, input c-value");
        double c = Double.parseDouble(scanner.next());

        System.out.format("a * x^2 + b * x + c = 0, where a = %s ; b = %s ; c = %s :\n", a, b, c);
        double[] roots = obtainRootsOfTheEquation(a, b, c);
        switch (roots.length) {
            case 0: {
                System.out.println("Equation doesn't have roots");
                break;
            }
            case 1: {
                System.out.println("Only one root of equation = " + roots[0]);
                break;
            }
            case 2: {
                System.out.format("First root = %f, second root = %f", roots[0], roots[1]);
                break;
            }
            default: {
                System.err.println("Equation cannot have more then 2 roots");
                break;
            }
        }
    }

    private static double[] obtainRootsOfTheEquation(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            double root = -(b / (2 * a));
            return new double[]{root};
        } else {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{firstRoot, secondRoot};
        }
    }
}