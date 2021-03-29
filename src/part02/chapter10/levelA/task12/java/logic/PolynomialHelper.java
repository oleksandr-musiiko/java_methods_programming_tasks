package part02.chapter10.levelA.task12.java.logic;

import java.util.ArrayList;
import java.util.List;

public class PolynomialHelper {

    public List<Double> multiplyTwoPolynomial(List<Double> firstCoefficients, List<Double> secondCoefficients) {
        int resultPower = firstCoefficients.size() - 1 + secondCoefficients.size() - 1;
        if (firstCoefficients.size() > secondCoefficients.size()) {
            List<Double> temp = firstCoefficients;
            firstCoefficients = secondCoefficients;
            secondCoefficients = temp;
        }
        List<Double> result = new ArrayList<>(resultPower);
        for (int index = 0; index <= resultPower; index++) {
            double coefficient = 0.0;
            if (index == 0) {
                result.add(firstCoefficients.get(0) * secondCoefficients.get(0));
                continue;
            }
            if (index < firstCoefficients.size()) {
                for (int first = 0; first <= index; first++) {
                    coefficient += firstCoefficients.get(first) * secondCoefficients.get(index - first);
                }
            } else if (index >= firstCoefficients.size() && index < secondCoefficients.size()) {
                int first = 0;
                for (int second = index; first < firstCoefficients.size(); first++, second--) {
                    coefficient += firstCoefficients.get(first) * secondCoefficients.get(second);
                }
            } else if (index >= secondCoefficients.size()) {
                int second = secondCoefficients.size() - 1;
                for (int first = index - second; first < firstCoefficients.size() && second >= 0; first++, second--) {
                    coefficient += firstCoefficients.get(first) * secondCoefficients.get(second);
                }
            }
            result.add(index, coefficient);
        }
        return result;
    }

    public double obtainValueOfPolynomial(double variable, List<Double> coefficients) {
        double result = 0;
        for (int index = 0; index < coefficients.size(); index++) {
            result += Math.pow(variable, coefficients.size() - 1 - index) * coefficients.get(index);
        }
        return result;
    }

    public void printPolynomial(double variable, List<Double> coefficients) {
        for (int i = 0; i < coefficients.size(); i++) {
            if (i < coefficients.size() - 1) {
                System.out.println(coefficients.get(i) + " * (" + variable + ")^" + (coefficients.size() - i - 1) + "\t+");
            } else {
                System.out.println(coefficients.get(i) + " * (" + variable + ")^" + (coefficients.size() - i - 1));
            }
        }
    }
}