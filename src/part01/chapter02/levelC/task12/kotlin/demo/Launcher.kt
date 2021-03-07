package part01.chapter02.levelC.task12.kotlin.demo

import part01.chapter02.levelC.console.kotlin.readInt
import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Min element = ${getMinELement(squareMatrix)}")

    println("Please, input row coordinate:")
    val rowIndex = readInt()
    println("Please, input column coordinate:")
    val columnIndex = readInt()

    println("Result:")
    printMatrix(turnMinElementToCoordinates(squareMatrix, rowIndex, columnIndex))
}

private fun turnMinElementToCoordinates(squareMatrix: Array<DoubleArray>, rowIndex: Int, columnIndex: Int): Array<DoubleArray> {
    val minElement = getMinELement(squareMatrix)
    val coordinatesInMatrix = getCoordinatesOfElement(squareMatrix, minElement) ?: return squareMatrix

    var result = cloneMatrix(squareMatrix)
    val shiftByRow = rowIndex - coordinatesInMatrix.rowIndex
    result = if (shiftByRow > 0) shiftMatrixUp(result, shiftByRow) else shiftMatrixDown(result, shiftByRow)
    val shiftByColumn = columnIndex - coordinatesInMatrix.columnIndex
    result = if (shiftByColumn > 0) shiftMatrixLeft(result, shiftByColumn) else shiftMatrixRight(result, shiftByColumn)
    return result
}

private fun shiftMatrixLeft(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    return shiftMatrixRight(squareMatrix, -k)
}

private fun shiftMatrixRight(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    val result = cloneMatrix(squareMatrix)
    for (rowIndex in result.indices) {
        val modifiedRow = squareMatrix[rowIndex].shiftToRight(k)
        result[rowIndex] = modifiedRow
    }
    return result
}

private fun shiftMatrixDown(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    return shiftMatrixUp(squareMatrix, -k)
}

private fun shiftMatrixUp(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    val n = squareMatrix.size

    val result = cloneMatrix(squareMatrix)
    for (columnIndex in 0 until n) {
        val currentColumn = DoubleArray(n)
        for (rowIndex in 0 until n) {
            currentColumn[rowIndex] = squareMatrix[rowIndex][columnIndex]
        }

        val modifiedColumn = currentColumn.shiftToLeft(k)
        for (rowIndex in 0 until n) {
            result[rowIndex][columnIndex] = modifiedColumn[rowIndex]
        }
    }
    return result
}

private fun DoubleArray.shiftToLeft(k: Int): DoubleArray {
    if (k < 0) return this.shiftToRight(-k)
    val absoluteShift = k % this.size

    val result = DoubleArray(this.size)
    for (i in result.indices) {
        val indexOfArray = if (i < this.size - absoluteShift) i + absoluteShift else i - (this.size - absoluteShift)
        result[i] = this[indexOfArray]
    }
    return result
}

private fun DoubleArray.shiftToRight(k: Int): DoubleArray {
    if (k < 0) return this.shiftToLeft(-k)
    val absoluteShift = k % this.size

    val result = DoubleArray(this.size)
    for (i in result.lastIndex downTo 0) {
        val indexOfArray = if (i >= absoluteShift) i - absoluteShift else (i + this.size) - absoluteShift
        result[i] = this[indexOfArray]
    }
    return result
}

private fun getCoordinatesOfElement(squareMatrix: Array<DoubleArray>, element: Double): CoordinatesInMatrix? {
    for (rowIndex in squareMatrix.indices) {
        for (columnIndex in squareMatrix[rowIndex].indices) {
            if (squareMatrix[rowIndex][columnIndex] == element) return CoordinatesInMatrix(rowIndex = rowIndex, columnIndex = columnIndex)
        }
    }
    return null
}

private fun getMinELement(squareMatrix: Array<DoubleArray>): Double {
    var result = Double.MAX_VALUE
    squareMatrix.forEach { row -> row.forEach { number -> result = minOf(result, number) } }
    return result
}

private data class CoordinatesInMatrix(
        val rowIndex: Int,
        val columnIndex: Int
)