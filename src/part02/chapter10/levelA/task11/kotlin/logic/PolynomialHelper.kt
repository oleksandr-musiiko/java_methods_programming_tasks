package part02.chapter10.levelA.task11.kotlin.logic

import kotlin.math.pow

object PolynomialHelper {

    fun addPolynomials(firstCoefficients: HashMap<Int, Double>, secondCoefficients: HashMap<Int, Double>): HashMap<Int, Double> {
        if (firstCoefficients.size != secondCoefficients.size) throw IllegalArgumentException()
        val countOfCoefficients = firstCoefficients.size
        val result = HashMap<Int, Double>(countOfCoefficients)
        for (i in 0 until  countOfCoefficients) {
            val firstCoefficient = firstCoefficients[i]
            val secondCoefficient = secondCoefficients[i]
            if (firstCoefficient != null && secondCoefficient != null) {
                result[i] = firstCoefficient + secondCoefficient
            } else {
                throw IllegalArgumentException()
            }
        }
        return result
    }

    fun obtainValueOfPolynomial(variable: Double, coefficients: HashMap<Int, Double>):Double {
        var result = 0.0
        for (i in 0 until coefficients.size) {
            val coefficient = coefficients[i] ?: throw IllegalArgumentException()
            result += coefficient * variable.pow(i)
        }
        return result
    }

    fun printPolynomial(variable: Double, coefficients: HashMap<Int, Double>) {
        for (i in 0 until coefficients.size) {
            if (i != coefficients.size - 1) {
                println("${coefficients[i]} * ($variable)^${coefficients.size - 1 -i}\t+")
            } else {
                println("${coefficients[i]} * ($variable)^${coefficients.size - 1 -i}")
            }
        }
    }
}