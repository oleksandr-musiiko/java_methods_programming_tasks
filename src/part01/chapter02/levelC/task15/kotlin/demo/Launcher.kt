package part01.chapter02.levelC.task15.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import kotlin.math.max
import kotlin.math.min

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Count of saddle points = ${obtainCountOfSaddlePoints(squareMatrix)}")
}

private fun obtainCountOfSaddlePoints(squareMatrix: Array<DoubleArray>): Int {
    val maxElementsInEveryColumns = getMaxElementsInEveryColumn(squareMatrix)
    val minElementsInEveryRows = getMinElementsInEveryRow(squareMatrix)

    var result = 0
    for (rowIndex in squareMatrix.indices) {
        for (columnIndex in squareMatrix[rowIndex].indices) {
            val elementOfSquareMatrix = squareMatrix[rowIndex][columnIndex]
            if (elementOfSquareMatrix == maxElementsInEveryColumns[columnIndex] &&
                    elementOfSquareMatrix == minElementsInEveryRows[rowIndex]) {
                result++
            }
        }
    }
    return result
}

private fun getMaxElementsInEveryColumn(squareMatrix: Array<DoubleArray>): DoubleArray {
    val n = squareMatrix.size

    val result = DoubleArray(n)
    for (columnIndex in result.indices) {
        result[columnIndex] = getMaxInColumn(squareMatrix, columnIndex)
    }
    return result
}

private fun getMinElementsInEveryRow(squareMatrix: Array<DoubleArray>): DoubleArray {
    val n = squareMatrix.size

    val result = DoubleArray(n)
    for (rowIndex in result.indices) {
        result[rowIndex] = getMinInRow(squareMatrix, rowIndex)
    }
    return result
}

private fun getMaxInColumn(squareMatrix: Array<DoubleArray>, columnIndex: Int): Double {
    var result = Double.MIN_VALUE
    for (rowIndex in squareMatrix.indices) {
        result = max(result, squareMatrix[rowIndex][columnIndex])
    }
    return result
}

private fun getMinInRow(squareMatrix: Array<DoubleArray>, rowIndex: Int): Double {
    var result = Double.MAX_VALUE
    squareMatrix[rowIndex].forEach { number -> result = min(result, number) }
    return result
}