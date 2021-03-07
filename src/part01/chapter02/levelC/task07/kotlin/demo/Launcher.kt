package part01.chapter02.levelC.task07.kotlin.demo

import part01.chapter02.levelC.console.kotlin.readInt
import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Turn counterclockwise. Please, input times to turn. For example:\n"
            + "'1' - 90 degrees, '2' - 180 degrees, '3' - 270 degrees")
    val timesToTurn = readInt()

    var resultSquareMatrix = cloneMatrix(squareMatrix)
    for (i in 0 until timesToTurn) {
        resultSquareMatrix = turn90DegreesCounterclockwise(resultSquareMatrix)
    }
    printMatrix(resultSquareMatrix)
}

private fun turn90DegreesCounterclockwise(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size
    val lastIndex = n - 1

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[columnIndex][lastIndex - rowIndex]
        }
    }
    return result
}