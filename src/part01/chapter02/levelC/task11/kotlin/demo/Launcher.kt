package part01.chapter02.levelC.task11.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Matrix with removed rows and columns with all zero elements:")
    printMatrix(removeRowAndColumnsWithAllZeroElements(squareMatrix))
}

private fun removeRowAndColumnsWithAllZeroElements(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val rowsWithAllZeroElements = getRowsAllZeroElements(squareMatrix)
    val columnsWithAllZeroElements = getColumnsAllZeroElements(squareMatrix)
    return removeColumns(
            removeRows(squareMatrix, rowsWithAllZeroElements),
            columnsWithAllZeroElements
    )
}

private fun removeColumns(matrix: Array<DoubleArray>, columnsForRemove: IntArray): Array<DoubleArray> {
    if (columnsForRemove.isEmpty()) return matrix
    var step = 0
    val resultColumnsLength = matrix[0].size - columnsForRemove.size

    val result = Array(matrix.size) { DoubleArray(resultColumnsLength) }
    for (matrixColumnIndex in matrix[0].indices) {
        if (step < columnsForRemove.size && matrixColumnIndex == columnsForRemove[step]) {
            step++
            continue
        }
        for (matrixRowIndex in matrix.indices) {
            result[matrixRowIndex][matrixColumnIndex - step] = matrix[matrixRowIndex][matrixColumnIndex]
        }
    }
    return result
}

private fun removeRows(matrix: Array<DoubleArray>, rowsForRemove: IntArray): Array<DoubleArray> {
    if (rowsForRemove.isEmpty()) return matrix
    var step = 0
    val resultRowLength = matrix.size - rowsForRemove.size

    val result = Array(resultRowLength) { DoubleArray(matrix[0].size) }
    for (matrixRowIndex in matrix.indices) {
        if (step < rowsForRemove.size && matrixRowIndex == rowsForRemove[step]) {
            step++
            continue
        }
        result[matrixRowIndex - step] = matrix[matrixRowIndex]
    }
    return result
}

private fun getRowsAllZeroElements(squareMatrix: Array<DoubleArray>): IntArray {
    val n = squareMatrix.size

    var result = IntArray(0)
    for (rowIndex in 0 until n) {
        var isAllRowZero = true
        for (columnIndex in 0 until n) {
            if (squareMatrix[rowIndex][columnIndex] != 0.0) {
                isAllRowZero = false
                break
            }
        }

        if (isAllRowZero) result = result.addValueToIntArray(rowIndex)
    }
    return result
}

private fun getColumnsAllZeroElements(squareMatrix: Array<DoubleArray>): IntArray {
    val n = squareMatrix.size

    var result = IntArray(0)
    for (columnIndex in 0 until n) {
        var isAllColumnZero = true
        for (rowIndex in 0 until n) {
            if (squareMatrix[rowIndex][columnIndex] != 0.0) {
                isAllColumnZero = false
                break
            }
        }

        if (isAllColumnZero) result = result.addValueToIntArray(columnIndex)
    }
    return result
}

private fun IntArray.addValueToIntArray(value: Int): IntArray {
    val result = this.copyOf(this.size + 1)
    result[result.lastIndex] = value
    return result
}