package part01.chapter01.levelB.task16.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        it.forEach { number ->
            if (number >= 0) {
                println("Pascal triangle for $number:")
                val pascalTriangle = getPascalTriangle(number)
                pascalTriangle.forEach { row ->
                    row.forEach { number ->
                        if (number == 0) print(" ") else print(number)
                    }
                    println()
                }
                return
            }
        }
        println("Numbers satisfying the condition were not found")
    }
}

private fun getPascalTriangle(number: Int): Array<IntArray> {
    val countOfRows = number + 1
    if (countOfRows == 1) {
        return arrayOf(intArrayOf(1))
    }
    val widthInNumbers = countOfRows * 2 - 1
    val result = Array(countOfRows) { IntArray(widthInNumbers) }
    for (i in 1 until widthInNumbers) {
        result[0][i] = if (i == widthInNumbers / 2) 1 else 0
    }
    val lastIndex = widthInNumbers - 1
    for (rowIndex in 1 until countOfRows) {
        for (i in 0 until widthInNumbers) {
            val leftIndex = if (i == 0) lastIndex else i - 1
            val rightIndex = if (i == lastIndex) 0 else i + 1
            result[rowIndex][i] = result[rowIndex - 1][leftIndex] + result[rowIndex - 1][rightIndex]
        }
    }
    return result
}