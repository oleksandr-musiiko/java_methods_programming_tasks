package part01.chapter02.levelC.task04.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Sum of matrix elements from first positive to second in all rows:")
    println(sumOfMatrixElementsFromFirstPositiveToSecondInRow(squareMatrix))
}

private fun sumOfMatrixElementsFromFirstPositiveToSecondInRow(matrix: Array<DoubleArray>): Double {
    var result = 0.0
    matrix.forEach { row ->
        result += sumOfElementsFromFirstPositiveToSecond(row)
    }
    return result
}

private fun sumOfElementsFromFirstPositiveToSecond(row: DoubleArray): Double {
    val indexes = getIndexesOfPositiveNumbers(row)
    if (indexes.size < 2) return 0.0
    val firstPositiveIndex = indexes[0]
    val secondPositiveIndex = indexes[1]

    var result = 0.0
    for (rowIndex in firstPositiveIndex + 1 until secondPositiveIndex) {
        result += row[rowIndex]
    }
    return result
}

private fun getIndexesOfPositiveNumbers(row: DoubleArray): IntArray {
    var countOfPositiveNumbers = 0
    row.forEach {
        if (it >= 0) countOfPositiveNumbers++
    }
    if (countOfPositiveNumbers == 0) return IntArray(0)

    val result = IntArray(countOfPositiveNumbers)
    var indexOfResult = 0
    for (i in row.indices) {
        if (row[i] >= 0) result[indexOfResult++] = i
    }
    return result
}