package part02.chapter10.levelA.task11.java.logic;

import java.util.HashMap;

public class PolynomialHelper {

    public HashMap<Integer, Double> addPolynomials(
            HashMap<Integer, Double> firstPolynomialsCoefficients,
            HashMap<Integer, Double> secondPolynomialsCoefficients
    ) {
        if (firstPolynomialsCoefficients.size() != secondPolynomialsCoefficients.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Double> result = new HashMap<>();
        for (int i = 0; i < firstPolynomialsCoefficients.size(); i++) {
            double currentCoefficient = firstPolynomialsCoefficients.get(i) + secondPolynomialsCoefficients.get(i);
            result.put(i, currentCoefficient);
        }
        return result;
    }

    public double obtainValueOfPolynomial(double variable, HashMap<Integer, Double> coefficients) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(variable, coefficients.size() - i - 1);
        }
        return result;
    }

    public void printPolynomial(double variable, HashMap<Integer, Double> coefficients) {
        for (int i = 0; i < coefficients.size(); i++) {
            if (i < coefficients.size() - 1) {
                System.out.println(coefficients.get(i) + " * (" + variable + ")^" + (coefficients.size() - i - 1) + "\t+");
            } else {
                System.out.println(coefficients.get(i) + " * (" + variable + ")^" + (coefficients.size() - i - 1));
            }
        }
    }
}