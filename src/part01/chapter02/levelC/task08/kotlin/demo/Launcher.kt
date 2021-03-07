package part01.chapter02.levelC.task08.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Determinate of matrix = ${obtainDeterminantOfSquareMatrix(squareMatrix)}")
}

private fun obtainDeterminantOfSquareMatrix(squareMatrix: Array<DoubleArray>): Double {
    return if (squareMatrix.size == 2) {
        obtainDeterminantMinSquareMatrix(squareMatrix)
    } else {
        val rowIndex = 0

        var result = 0.0
        for (columnIndex in squareMatrix.indices) {
            val determinateOfMinor = obtainDeterminantOfSquareMatrix(obtainMinorOfMatrix(squareMatrix, rowIndex, columnIndex))
            if (columnIndex % 2 == 0) {
                result += squareMatrix[rowIndex][columnIndex] * determinateOfMinor
            } else {
                result -= squareMatrix[rowIndex][columnIndex] * determinateOfMinor
            }
        }
        result
    }
}

private fun obtainMinorOfMatrix(squareMatrix: Array<DoubleArray>, rowIndexOfElement: Int, columnIndexOfElement: Int): Array<DoubleArray> {
    if (squareMatrix.size < 3) {
        throw IllegalArgumentException()
    }
    val newLength = squareMatrix.size - 1

    val result = Array(newLength) { DoubleArray(newLength) }
    for (minorRowIndex in 0 until newLength) {
        for (minorColumnIndex in 0 until newLength) {
            val indexRowFromSquareMatrix = if (minorRowIndex < rowIndexOfElement) minorRowIndex else minorRowIndex + 1
            val indexColumnFromSquareMatrix = if (minorColumnIndex < columnIndexOfElement) minorColumnIndex else minorColumnIndex + 1
            result[minorRowIndex][minorColumnIndex] = squareMatrix[indexRowFromSquareMatrix][indexColumnFromSquareMatrix]
        }
    }
    return result
}

private fun obtainDeterminantMinSquareMatrix(minSquareMatrix: Array<DoubleArray>): Double {
    if (minSquareMatrix.size != 2) {
        throw IllegalArgumentException()
    }
    return minSquareMatrix[0][0] * minSquareMatrix[1][1] - minSquareMatrix[1][0] * minSquareMatrix[0][1]
}