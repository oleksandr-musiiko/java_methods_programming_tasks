package part01.chapter02.levelC.task01.kotlin.demo

import part01.chapter02.levelC.matrix.kotlin.MatrixCreator
import part01.chapter02.levelC.matrix.kotlin.printMatrix
import part01.chapter02.levelC.task01.kotlin.util.TimesValueInArrayCounter
import part01.chapter02.levelC.console.kotlin.readInt
import part01.chapter02.levelC.matrix.kotlin.cloneMatrix

fun main() {
    val squareMatrix = MatrixCreator.getSquareMatrix()
    println("Please input Int k (index from 0 to N)")
    val k = readInt()
    if (k >= squareMatrix.size || k < 0) {
        System.err.println("Incorrect K")
        return
    }

    println("'1' - for sort columns, '2' - for sort rows")
    when (readLine()) {
        "1" -> {
            println("Matrix with sorted columns:")
            printMatrix(sortColumnsByKRow(squareMatrix, k))
        }
        "2" -> {
            println("Matrix with sorted rows:")
            printMatrix(sortRowsByKColumn(squareMatrix, k))
        }
        else -> System.err.println("Unsupported option")
    }
}

private fun sortColumnsByKRow(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    val order = getOrder(squareMatrix[k])
    val n = squareMatrix.size

    val result = cloneMatrix(squareMatrix)
    for (columnIndex in 0 until n) {
        val columnArray = DoubleArray(n)
        for (rowIndex in 0 until n) {
            columnArray[rowIndex] = squareMatrix[rowIndex][columnIndex]
        }

        val resultColumn = sortArrayInOrder(columnArray, order)
        for (rowIndex in 0 until n) {
            result[rowIndex][columnIndex] = resultColumn[rowIndex]
        }
    }
    return result
}

private fun sortRowsByKColumn(squareMatrix: Array<DoubleArray>, k: Int): Array<DoubleArray> {
    val n = squareMatrix.size

    val kColumn = DoubleArray(n)
    for (i in 0 until n) {
        kColumn[i] = squareMatrix[i][k]
    }
    val order = getOrder(kColumn)

    val result = cloneMatrix(squareMatrix)
    for (rowIndex in 0 until n) {
        val row = squareMatrix[rowIndex]
        val resultRow = sortArrayInOrder(row, order)
        result[rowIndex] = resultRow
    }
    return result
}

private fun sortArrayInOrder(arrayForSort: DoubleArray, order: IntArray): DoubleArray {
    val ascendingSortedArray = arrayForSort.clone().apply { sort() }

    val result = DoubleArray(order.size)
    for (i in result.indices) {
        result[i] = ascendingSortedArray[order[i]]
    }
    return result
}

private fun getOrder(array: DoubleArray): IntArray {
    val sortedArray = array.clone().apply { sort() }
    var remainingTimesOfNumbers = TimesValueInArrayCounter.obtainTimesInArrayValueAndCount(array)

    val result = IntArray(array.size)
    for (i in array.indices) {
        val number = array[i]
        val times = TimesValueInArrayCounter.getTimes(remainingTimesOfNumbers, number)
        remainingTimesOfNumbers = TimesValueInArrayCounter.removeTimeFromTimesArray(remainingTimesOfNumbers, number)
        result[i] = sortedArray.indexOf(number) + times - 1
    }
    return result
}