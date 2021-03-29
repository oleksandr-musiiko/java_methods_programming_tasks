package part02.chapter10.levelA.task11.java.demo;

import part02.chapter10.levelA.task11.java.logic.PolynomialHelper;

import java.util.HashMap;
import java.util.Random;

public class Launcher {

    public static void main(String[] args) {
        double polynomialVariable = 8.4;
        int polynomialPower = 8;
        HashMap<Integer, Double> polynomialCoefficients1 = new HashMap<Integer, Double>() {
            {
                Random randomizer = new Random();
                for (int i = 0; i <= polynomialPower; i++) {
                    put(i, randomizer.nextDouble() * randomizer.nextInt(16));
                }
            }
        };
        System.out.println(polynomialCoefficients1);
        HashMap<Integer, Double> polynomialCoefficients2 = new HashMap<Integer, Double>() {
            {
                Random randomizer = new Random();
                for (int i = 0; i <= polynomialPower; i++) {
                    put(i, randomizer.nextDouble() * randomizer.nextInt(16));
                }
            }
        };
        System.out.println(polynomialCoefficients2);
        PolynomialHelper polynomialHelper = new PolynomialHelper();
        HashMap<Integer, Double> additionOfTwoPolynomial = polynomialHelper.addPolynomials(polynomialCoefficients1, polynomialCoefficients2);
        polynomialHelper.printPolynomial(polynomialVariable, additionOfTwoPolynomial);
        System.out.println("double value of polynomial:\n" +
                polynomialHelper.obtainValueOfPolynomial(polynomialVariable, additionOfTwoPolynomial));
    }
}