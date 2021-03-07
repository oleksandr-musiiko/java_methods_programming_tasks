package part01.chapter02.levelC.task09.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result:")
    printMatrix(subtractArithmeticMeanOfEachRowFromMatrixElements(squareMatrix))
}

private fun subtractArithmeticMeanOfEachRowFromMatrixElements(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        val arithmeticMeanOfRow = squareMatrix[rowIndex].obtainArithmeticMeanOfRow()
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[rowIndex][columnIndex] - arithmeticMeanOfRow
        }
    }
    return result
}

private fun DoubleArray.obtainArithmeticMeanOfRow(): Double = this.sum() / this.size