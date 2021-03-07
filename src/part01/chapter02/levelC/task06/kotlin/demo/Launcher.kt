package part01.chapter02.levelC.task06.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("M-norm = ${obtainMSquareMatrixNorm(squareMatrix)}")
    println("L-norm = ${obtainLSquareMatrixNorm(squareMatrix)}")
    println("K-norm = ${obtainKSquareMatrixNorm(squareMatrix)}")
}

private fun obtainMSquareMatrixNorm(squareMatrix: Array<DoubleArray>): Double {
    var result = 0.0
    squareMatrix.forEach { row ->
        var sumOfAbsOfElementsInRow = 0.0
        row.forEach {
            sumOfAbsOfElementsInRow += abs(it)
        }

        result = max(result, sumOfAbsOfElementsInRow)
    }
    return result
}

private fun obtainLSquareMatrixNorm(squareMatrix: Array<DoubleArray>): Double {
    val n = squareMatrix.size

    var result = 0.0
    for (columnIndex in 0 until n) {
        var sumOfAbsOfElementsInColumn = 0.0
        for (rowIndex in 0 until n) {
            sumOfAbsOfElementsInColumn += abs(squareMatrix[rowIndex][columnIndex])
        }

        result = max(result, sumOfAbsOfElementsInColumn)
    }
    return result
}

private fun obtainKSquareMatrixNorm(squareMatrix: Array<DoubleArray>): Double {
    var sumOfSquaresOfElements = 0.0
    squareMatrix.forEach { row ->
        row.forEach { number ->
            sumOfSquaresOfElements += number.pow(2)
        }
    }
    return sqrt(sumOfSquaresOfElements)
}