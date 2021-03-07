package part01.chapter02.levelC.task14.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix
import kotlin.math.round

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result matrix with rounded elements")
    printMatrix(roundElementsInMatrix(squareMatrix))
}

private fun roundElementsInMatrix(matrix: Array<DoubleArray>): Array<LongArray> {
    val result = Array(matrix.size) { longArrayOf() }
    for (rowIndex in matrix.indices) {
        result[rowIndex] = LongArray(matrix[rowIndex].size)
        for (columnIndex in result[rowIndex].indices) {
            result[rowIndex][columnIndex] = round(matrix[rowIndex][columnIndex]).toLong()
        }
    }
    return result
}