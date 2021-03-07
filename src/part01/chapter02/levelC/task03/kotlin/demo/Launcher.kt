package part01.chapter02.levelC.task03.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import kotlin.math.max

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Max count ascending order elements in a row = ${maxCountInAscending(squareMatrix)}")
    println("Max count descending order elements in a row = ${maxCountInDescending(squareMatrix)}")
}

private fun maxCountInDescending(squareMatrix: Array<DoubleArray>): Int =
        maxCountInAscending(invertSquareMatrix(squareMatrix))

private fun maxCountInAscending(squareMatrix: Array<DoubleArray>): Int {
    val maxCountAscendingRows = maxCountInAscendingInRows(squareMatrix)
    val maxCountAscendingColumns = maxCountInAscendingInRows(turnSquareMatrix(squareMatrix))
    val maxCountAscendingInRightDiagonals = maxCountInAscendingOrderInRightDiagonals(squareMatrix)
    val maxCountAscendingInLeftDiagonals = maxCountInAscendingOrderInRightDiagonals(mirrorHorizontalSquareMatrix(squareMatrix))

    return max(
            max(maxCountAscendingRows, maxCountAscendingColumns),
            max(maxCountAscendingInRightDiagonals, maxCountAscendingInLeftDiagonals)
    )
}

private fun maxCountInAscendingInRows(squareMatrix: Array<DoubleArray>): Int {
    val n = squareMatrix.size

    var result = 0
    squareMatrix.forEach { row ->
        var countOfAscendingFragmentInRow = 1
        var maxCountInCurrentRow = countOfAscendingFragmentInRow
        for (columnIndex in 1 until n) {
            if (row[columnIndex] >= row[columnIndex - 1]) {
                countOfAscendingFragmentInRow++
            } else {
                maxCountInCurrentRow = max(maxCountInCurrentRow, countOfAscendingFragmentInRow)
                countOfAscendingFragmentInRow = 1
            }
        }

        maxCountInCurrentRow = max(maxCountInCurrentRow, countOfAscendingFragmentInRow)
        result = max(result, maxCountInCurrentRow)
    }
    return result
}

private fun maxCountInAscendingOrderInRightDiagonals(squareMatrix: Array<DoubleArray>): Int {
    val n = squareMatrix.size
    val countOfDiagonals = 2 * (n - 2) + 1
    val numberOfAverageDiagonal = countOfDiagonals / 2 + 1

    var result = 0
    for (i in 0 until countOfDiagonals) {
        var startRow: Int
        var startColumn: Int
        if (i < numberOfAverageDiagonal) {
            startRow = i + 1
            startColumn = 0
        } else {
            startRow = n - 1
            startColumn = (i - numberOfAverageDiagonal) + 1
        }

        val maximumStep = if (startRow < n - 1) startRow else (n - i) + 1

        var countOfAscendingFragmentOfDiagonal = 1
        var maxCountInCurrentDiagonal = countOfAscendingFragmentOfDiagonal
        for (step in 1..maximumStep) {
            if (squareMatrix[startRow - step][startColumn + step] >= squareMatrix[startRow - step + 1][startColumn + step - 1]) {
                countOfAscendingFragmentOfDiagonal++
            } else {
                maxCountInCurrentDiagonal = max(maxCountInCurrentDiagonal, countOfAscendingFragmentOfDiagonal)
                countOfAscendingFragmentOfDiagonal = 1
            }
        }

        maxCountInCurrentDiagonal = max(maxCountInCurrentDiagonal, countOfAscendingFragmentOfDiagonal)
        result = max(result, maxCountInCurrentDiagonal)
    }
    return result
}

private fun turnSquareMatrix(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[columnIndex][rowIndex]
        }
    }
    return result
}

private fun mirrorHorizontalSquareMatrix(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size
    val lastIndex = n - 1

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[lastIndex - rowIndex][columnIndex]
        }
    }
    return result
}

private fun invertSquareMatrix(squareMatrix: Array<DoubleArray>): Array<DoubleArray> {
    val n = squareMatrix.size

    val result = Array(n) { DoubleArray(n) }
    for (rowIndex in 0 until n) {
        for (columnIndex in 0 until n) {
            result[rowIndex][columnIndex] = squareMatrix[(n - 1) - rowIndex][(n - 1) - columnIndex]
        }
    }
    return result
}