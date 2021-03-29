package part02.chapter10.levelA.task11.kotlin.demo

import part02.chapter10.levelA.task11.kotlin.logic.PolynomialHelper
import kotlin.random.Random

fun main() {
    val polynomialVariable = 5.5
    val polynomialPower = 10
    val coefficients1 = HashMap<Int, Double>().apply {
        for (i in 0..polynomialPower) {
            put(i,  Random.nextDouble(0.0, 16.0))
        }
    }
    val coefficients2 = HashMap<Int, Double>().apply {
        for (i in 0..polynomialPower) {
            put(i, Random.nextDouble(0.0, 16.0))
        }
    }
    val result = PolynomialHelper.addPolynomials(coefficients1, coefficients2)
    PolynomialHelper.printPolynomial(polynomialVariable, result)
    println(PolynomialHelper.obtainValueOfPolynomial(polynomialVariable, result))
}