package part01.chapter02.levelC.task10.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix
import kotlin.math.max

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Matrix with removed rows and columns with max element:")
    printMatrix(removeRowsAndColumnsWithMaxElement(squareMatrix))
}

private fun removeRowsAndColumnsWithMaxElement(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val maxElement = findMaxElementInSquareMatrix(squareMatrix)

    val rowsWithMaxElement = getRowsWithElement(squareMatrix, maxElement)
    val columnsWithMaxELement = getColumnsWithElement(squareMatrix, maxElement)
    return removeColumns(
            removeRows(squareMatrix, rowsWithMaxElement),
            columnsWithMaxELement
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

private fun getRowsWithElement(squareMatrix: Array<DoubleArray>, element: Double): IntArray {
    var result = IntArray(0)
    for (rowIndex in squareMatrix.indices) {
        for (columnIndex in squareMatrix.indices) {
            if (squareMatrix[rowIndex][columnIndex] == element) {
                result = result.addValueToIntArray(rowIndex)
                break
            }
        }
    }
    return result
}

private fun getColumnsWithElement(squareMatrix: Array<DoubleArray>, element: Double): IntArray {
    val n = squareMatrix.size

    var result = IntArray(0)
    for (columnIndex in 0 until n) {
        for (rowIndex in 0 until n) {
            if (squareMatrix[rowIndex][columnIndex] == element) {
                result = result.addValueToIntArray(columnIndex)
                break
            }
        }
    }
    return result
}

private fun findMaxElementInSquareMatrix(squareMatrix: Array<DoubleArray>): Double {
    var result = Double.MIN_VALUE
    squareMatrix.forEach { row -> row.forEach { number -> result = max(result, number) } }
    return result
}

private fun IntArray.addValueToIntArray(value: Int): IntArray {
    val result = this.copyOf(this.size + 1)
    result[result.lastIndex] = value
    return result
}