package part01.chapter02.levelC.task19.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix
import kotlin.math.abs

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result square matrix with sorted columns by characteristics:")
    printMatrix(sortColumnsByCharacteristics(squareMatrix))
}

private fun sortColumnsByCharacteristics(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    val order = arrayOfNulls<ColumnIndexAndCharacteristic>(n)
    for (orderIndex in order.indices) {
        order[orderIndex] = ColumnIndexAndCharacteristic(orderIndex, obtainCharacteristicOfColumn(squareMatrix, orderIndex))
    }
    val sortedOrder = order.clone().requireNoNulls()
    for (outIndex in n - 1 downTo 1) {
        for (inIndex in 0 until outIndex) {
            if (sortedOrder[inIndex].characteristic > sortedOrder[inIndex + 1].characteristic) {
                val temp = sortedOrder[inIndex]
                sortedOrder[inIndex] = sortedOrder[inIndex + 1]
                sortedOrder[inIndex + 1] = temp
            }
        }
    }

    val result = Array(n) { DoubleArray(n) }
    for (resultColumnIndex in 0 until n) {
        val columnIndexFromMatrix = sortedOrder[resultColumnIndex].columnIndex
        for (rowIndex in 0 until n) {
            result[rowIndex][resultColumnIndex] = squareMatrix[rowIndex][columnIndexFromMatrix]
        }
    }
    return result
}

private fun obtainCharacteristicOfColumn(squareMatrix: Array<DoubleArray>, columnIndex: Int): Double {
    val n = squareMatrix.size

    var result = 0.0
    for (rowIndex in 0 until n) {
        result += abs(squareMatrix[rowIndex][columnIndex])
    }
    return result
}

private data class ColumnIndexAndCharacteristic(
        val columnIndex: Int,
        val characteristic: Double
)