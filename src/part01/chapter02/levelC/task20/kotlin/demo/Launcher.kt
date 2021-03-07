package part01.chapter02.levelC.task20.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix
import part01.chapter02.levelC.matrix.kotlin.printMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Result matrix where diagonal filled with maximum elements from top to bottom:")
    printMatrix(fillTheDiagonalWithMaximumFromTopToBottom(squareMatrix))
}

private fun fillTheDiagonalWithMaximumFromTopToBottom(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    var result = cloneMatrix(squareMatrix)
    for (indexDiagonal in 0 until n) {
        var coordinatesMaximumRemaining = Coordinates(indexDiagonal, indexDiagonal)

        for (rowIndex in 0 until n) {
            for (columnIndex in 0 until n) {
                if (rowIndex == columnIndex && rowIndex < indexDiagonal) continue

                if (result[rowIndex][columnIndex] >
                        result[coordinatesMaximumRemaining.rowIndex][coordinatesMaximumRemaining.columnIndex]) {
                    coordinatesMaximumRemaining = coordinatesMaximumRemaining.copy(rowIndex = rowIndex, columnIndex = columnIndex)
                }
            }
        }
        result = swap(
                result,
                fromCoordinates = coordinatesMaximumRemaining,
                toCoordinates = Coordinates(indexDiagonal, indexDiagonal)
        )
    }
    return result
}

private fun swap(
        squareMatrix: Array<DoubleArray>,
        fromCoordinates: Coordinates,
        toCoordinates: Coordinates
): Array<DoubleArray> {
    val result = cloneMatrix(squareMatrix)
    val temp = result[fromCoordinates.rowIndex][fromCoordinates.columnIndex]
    result[fromCoordinates.rowIndex][fromCoordinates.columnIndex] = result[toCoordinates.rowIndex][toCoordinates.columnIndex]
    result[toCoordinates.rowIndex][toCoordinates.columnIndex] = temp
    return result
}

private data class Coordinates(
        val rowIndex: Int,
        val columnIndex: Int
)