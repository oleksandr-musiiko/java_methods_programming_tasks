package part02.chapter10.levelA.task12.java.demo;

import part02.chapter10.levelA.task12.java.logic.PolynomialHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Launcher {

    public static void main(String[] args) {
        double variable = 4.6;
        int firstPolynomialPower = 3;
        int secondPolynomialPower = 5;
        List<Double> firstCoefficients = new ArrayList<Double>() {
            {
                Random randomizer = new Random();
                for (int i = 0; i <= firstPolynomialPower; i++) {
                    add(randomizer.nextDouble() * randomizer.nextInt(8));
                }
            }
        };
        List<Double> secondCoefficients = new ArrayList<Double>() {
            {
                Random randomizer = new Random();
                for (int i = 0; i <= secondPolynomialPower; i++) {
                    add(randomizer.nextDouble() + randomizer.nextInt(8));
                }
            }
        };
        PolynomialHelper polynomialHelper = new PolynomialHelper();
        List<Double> multipliedCoefficients = polynomialHelper.multiplyTwoPolynomial(firstCoefficients, secondCoefficients);
        polynomialHelper.printPolynomial(variable, multipliedCoefficients);
        System.out.println(polynomialHelper.obtainValueOfPolynomial(variable, multipliedCoefficients));
    }
}