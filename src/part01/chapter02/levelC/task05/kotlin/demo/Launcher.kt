package part01.chapter02.levelC.task05.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Transposed matrix:")
    printMatrix(transposeSquareMatrix(squareMatrix))
}

private fun transposeSquareMatrix(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[columnIndex][rowIndex]
        }
    }
    return result
}