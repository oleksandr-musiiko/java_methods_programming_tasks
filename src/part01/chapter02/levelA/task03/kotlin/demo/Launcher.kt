package part01.chapter02.levelA.task03.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    if (numbers.isEmpty()) return

    val averageLength = getAverageNumberLength(numbers)
    println("Average length of numbers = $averageLength")
    println("More lengths from average:")
    numbers.filter { it.toString().length > averageLength }.forEach { print("$it\t") }
    println()
    println("Less lengths from average:")
    numbers.filter { it.toString().length < averageLength }.forEach { print("$it\t") }
}

private fun getAverageNumberLength(numbers: IntArray): Int {
    var matrixWithLengthAndCount = arrayOf(IntArray(2))
    numbers.forEach {
        val lengthOfNumber = it.toString().length
        if (containsLengthInMatrix(matrixWithLengthAndCount, lengthOfNumber)) {
            val indexOfLength = indexOfLengthMatrix(matrixWithLengthAndCount, lengthOfNumber)
            matrixWithLengthAndCount[indexOfLength][1]++
        } else {
            matrixWithLengthAndCount = addLengthToMatrixValueAndCount(matrixWithLengthAndCount, lengthOfNumber)
        }
    }
    val arithmeticMeanOfLengthOfNumbers = numbers.size / matrixWithLengthAndCount.size
    var minDistanceToMedian = Int.MAX_VALUE

    var result = 0
    matrixWithLengthAndCount.forEach {
        val count = it[1]
        if (arithmeticMeanOfLengthOfNumbers - count < minDistanceToMedian) {
            minDistanceToMedian = arithmeticMeanOfLengthOfNumbers - count
            result = count
        }
    }
    return result
}

private fun containsLengthInMatrix(matrix: Array<IntArray>, lengthOfNumber: Int) = indexOfLengthMatrix(matrix, lengthOfNumber) != -1

private fun indexOfLengthMatrix(matrix: Array<IntArray>, lengthOfNumber: Int): Int {
    for (i in matrix.indices) {
        val row = matrix[i]
        if (row[0] == lengthOfNumber) return i
    }
    return -1
}

private fun addLengthToMatrixValueAndCount(matrix: Array<IntArray>, lengthOfNumber: Int): Array<IntArray> {
    if (matrix.isEmpty()) {
        return arrayOf(intArrayOf(lengthOfNumber, 1))
    }

    val result = Array(matrix.size + 1) { IntArray(2) }
    for (i in matrix.indices) {
        result[i] = matrix[i]
    }
    result[result.lastIndex] = intArrayOf(lengthOfNumber, 1)
    return result
}