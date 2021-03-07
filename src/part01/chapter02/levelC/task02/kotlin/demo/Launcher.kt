package part01.chapter02.levelC.task02.kotlin.demo

import part01.chapter02.levelC.console.kotlin.readInt
import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Please input int K - count of shifting")
    val k = readInt()

    println("Shift:\n" + "'1' - right, '2' - left, '3' - up, '4' - down")
    when (readLine()) {
        "1" -> {
            println("k = $k , right shifting")
            printMatrix(shiftMatrixRight(squareMatrix, k))
        }
        "2" -> {
            println("k = $k , left shifting")
            printMatrix(shiftMatrixLeft(squareMatrix, k))
        }
        "3" -> {
            println("k = $k , up shifting")
            printMatrix(shiftMatrixUp(squareMatrix, k))
        }
        "4" -> {
            println("k = $k , down shifting")
            printMatrix(shiftMatrixDown(squareMatrix, k))
        }
        else -> println("Incorrect option")
    }
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