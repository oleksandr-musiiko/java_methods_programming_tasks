package part01.chapter02.levelC.task18.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import kotlin.math.min

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Min local minimum element = ${getMinLocalMinimumElement(squareMatrix)}")
}

private fun getMinLocalMinimumElement(squareMatrix: Array<DoubleArray>): Double? {
    val n = squareMatrix.size

    var result = Double.MAX_VALUE
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            if (isLocalMinimum(squareMatrix, rowIndex, columnIndex)) result = min(result, squareMatrix[rowIndex][columnIndex])
        }
    }
    return if (result == Double.MAX_VALUE) null else result
}

private fun isLocalMinimum(squareMatrix: Array<DoubleArray>, rowIndexOfElement: Int, columnIndexOfElement: Int): Boolean {
    val n = squareMatrix.size
    val element = squareMatrix[rowIndexOfElement][columnIndexOfElement]

    val startRowIndex = if (rowIndexOfElement == 0) 0 else rowIndexOfElement - 1
    val finishRowIndex = if (rowIndexOfElement == n - 1) n - 1 else rowIndexOfElement + 1
    val startColumnIndex = if (columnIndexOfElement == 0) 0 else columnIndexOfElement - 1
    val finishColumnIndex = if (columnIndexOfElement == n - 1) n - 1 else columnIndexOfElement + 1

    for (rowIndex in startRowIndex..finishRowIndex) {
        for (columnIndex in startColumnIndex..finishColumnIndex) {
            if (rowIndex == rowIndexOfElement && columnIndex == columnIndexOfElement) continue
            if (squareMatrix[rowIndex][columnIndex] <= element) return false
        }
    }
    return true
}