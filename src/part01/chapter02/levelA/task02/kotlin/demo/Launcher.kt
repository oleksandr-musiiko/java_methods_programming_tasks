package part01.chapter02.levelA.task02.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()

    val sortedNumbersByLength = sortNumbersByLengthOfNumber(numbers)
    println("Ascending order by length:")
    sortedNumbersByLength.forEach { print("$it\t") }
    println()
    println("Descending order by length:")
    for (i in sortedNumbersByLength.size - 1 downTo 0) {
        print("${sortedNumbersByLength[i]}\t")
    }
}

private fun sortNumbersByLengthOfNumber(numbersForSort: IntArray): IntArray {
    val result = numbersForSort.clone()
    for (outIndex in result.size - 1 downTo 1) {
        for (inIndex in 0 until outIndex) {
            if (result[inIndex].toString().length > result[inIndex + 1].toString().length) {
                val temp = result[inIndex]
                result[inIndex] = result[inIndex + 1]
                result[inIndex + 1] = temp
            }
        }
    }
    return result
}