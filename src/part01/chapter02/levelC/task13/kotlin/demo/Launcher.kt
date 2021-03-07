package part01.chapter02.levelC.task13.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result square matrix, where zero elements shift to end in every row")
    printMatrix(shiftZeroElementsToEndOfRows(squareMatrix))
}

private fun shiftZeroElementsToEndOfRows(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val result = cloneMatrix(squareMatrix)
    for (rowIndex in squareMatrix.indices) {
        for (outColumnIndex in squareMatrix[rowIndex].lastIndex downTo 0) {
            for (inColumnIndex in 0 until outColumnIndex) {
                if (result[rowIndex][inColumnIndex] == 0.0) {
                    result[rowIndex][inColumnIndex] = result[rowIndex][inColumnIndex + 1]
                    result[rowIndex][inColumnIndex + 1] = 0.0
                }
            }
        }
    }
    return result
}