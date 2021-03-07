package part01.chapter02.levelC.task17.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Count of local minimum elements = ${getCountOfLocalMinimumElements(squareMatrix)}")
}

private fun getCountOfLocalMinimumElements(squareMatrix: Array<DoubleArray>): Int {
    val n = squareMatrix.size

    var result = 0
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            if (isLocalMinimum(squareMatrix, rowIndex, columnIndex)) result++
        }
    }
    return result
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