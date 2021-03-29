package part02.chapter10.levelA.task12.kotlin.demo

import part02.chapter10.levelA.task12.kotlin.logic.PolynomialHelper
import kotlin.random.Random

fun main() {
    val variable = 3.7

    val firstPolynomialPower = 3
    val secondPolynomialPower = 5
    val firstCoefficients = mutableListOf<Double>().apply {
        for (i in 0..firstPolynomialPower) {
            add(Random.nextDouble(0.0, 8.0))
        }
    }.toList()
    val secondCoefficients = mutableListOf<Double>().apply {
        for (i in 0..secondPolynomialPower) {
            add(Random.nextDouble(0.0, 4.0))
        }
    }

    val multipliedCoefficients = PolynomialHelper.multiplyTwoPolynomials(firstCoefficients, secondCoefficients)

    PolynomialHelper.printPolynomial(variable, multipliedCoefficients)
    println(PolynomialHelper.obtainValueOfPolynomial(variable, multipliedCoefficients))
}