package part01.chapter02.levelC.task16.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result square matrix with sorted rows by sum of elements:")
    printMatrix(sortRowsBySumOfElements(squareMatrix))
}

private fun sortRowsBySumOfElements(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val order = arrayOfNulls<RowIndexOfMatrixAndSumOfElements>(matrix.size)
    for (orderIndex in order.indices) {
        order[orderIndex] = RowIndexOfMatrixAndSumOfElements(orderIndex, matrix[orderIndex].sum())
    }
    val sortedOrder = order.clone().requireNoNulls()
    for (outOrderIndex in order.lastIndex downTo 1) {
        for (inOrderIndex in 0 until outOrderIndex) {
            if (sortedOrder[inOrderIndex].sumOfElements > sortedOrder[inOrderIndex + 1].sumOfElements) {
                val temp = sortedOrder[inOrderIndex]
                sortedOrder[inOrderIndex] = sortedOrder[inOrderIndex + 1]
                sortedOrder[inOrderIndex + 1] = temp
            }
        }
    }

    val result = Array(matrix.size) { doubleArrayOf() }
    for (resultRowIndex in result.indices) {
        result[resultRowIndex] = matrix[sortedOrder[resultRowIndex].rowIndexOfMatrix]
    }
    return result
}

private data class RowIndexOfMatrixAndSumOfElements(
        val rowIndexOfMatrix: Int,
        val sumOfElements: Double
)