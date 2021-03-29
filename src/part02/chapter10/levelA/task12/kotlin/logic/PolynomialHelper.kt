package part02.chapter10.levelA.task12.kotlin.logic

import kotlin.math.pow

object PolynomialHelper {

    fun multiplyTwoPolynomials(firstCoefficients: List<Double>, secondCoefficients: List<Double>): List<Double> {
        val smallerBySizeCoefficients: List<Double>
        val biggerBySizeCoefficients: List<Double>
        if (firstCoefficients.size < secondCoefficients.size) {
            smallerBySizeCoefficients = firstCoefficients
            biggerBySizeCoefficients = secondCoefficients
        } else {
            smallerBySizeCoefficients = secondCoefficients
            biggerBySizeCoefficients = firstCoefficients
        }
        val resultPower = (smallerBySizeCoefficients.size - 1) + (biggerBySizeCoefficients.size - 1)
        val result = mutableListOf<Double>()
        for (index in 0..resultPower) {
            var currentCoefficient = 0.0
            when {
                index == 0 -> {
                    currentCoefficient = smallerBySizeCoefficients[0] * biggerBySizeCoefficients[0]

                }
                index < smallerBySizeCoefficients.size -> {
                    for (smallerCoefficientsIndex in 0..index) {
                        currentCoefficient +=
                                smallerBySizeCoefficients[smallerCoefficientsIndex] *
                                biggerBySizeCoefficients[index - smallerCoefficientsIndex]
                    }
                }
                index >= smallerBySizeCoefficients.size && index < biggerBySizeCoefficients.size -> {
                    var smallerCoefficientsIndex = 0
                    var biggerCoefficientsIndex = index
                    while (smallerCoefficientsIndex < smallerBySizeCoefficients.size) {
                        currentCoefficient +=
                                smallerBySizeCoefficients[smallerCoefficientsIndex] *
                                        biggerBySizeCoefficients[biggerCoefficientsIndex]
                        smallerCoefficientsIndex++
                        biggerCoefficientsIndex--
                    }
                }
                index >= biggerBySizeCoefficients.size -> {
                    var biggerCoefficientsIndex = biggerBySizeCoefficients.lastIndex
                    var smallerCoefficientsIndex = index - biggerCoefficientsIndex
                    while (smallerCoefficientsIndex < smallerBySizeCoefficients.size && biggerCoefficientsIndex >= 0) {
                        currentCoefficient +=
                                smallerBySizeCoefficients[smallerCoefficientsIndex] *
                                        biggerBySizeCoefficients[biggerCoefficientsIndex]
                        biggerCoefficientsIndex--
                        smallerCoefficientsIndex++
                    }
                }
            }
            result.add(index, currentCoefficient)
        }
        return result
    }

    fun obtainValueOfPolynomial(variable: Double, coefficients: List<Double>): Double {
        var result = 0.0
        for (index in coefficients.indices) {
            result += variable.pow(coefficients.lastIndex - index) * coefficients[index]
        }
        return result
    }

    fun printPolynomial(variable: Double, coefficients: List<Double>) {
        for (index in coefficients.indices) {
            if (index < coefficients.lastIndex) {
                println("${coefficients[index]} * ($variable)^${coefficients.lastIndex - index}\t+")
            } else {
                println("${coefficients[index]} * ($variable)^${coefficients.lastIndex - index}.")
            }
        }
    }
}