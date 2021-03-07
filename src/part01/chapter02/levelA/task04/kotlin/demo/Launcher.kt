package part01.chapter02.levelA.task04.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader
import kotlin.math.absoluteValue

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    if (numbers.isEmpty()) {
        return
    }

    val numberWithMinCountOfDifferentDigits = getNumberWithMinCountOfDifferentDigits(numbers)
    println("Number with min count of different digits = $numberWithMinCountOfDifferentDigits")
}

private fun getNumberWithMinCountOfDifferentDigits(numbers: IntArray): Int {
    var minCountOfDigits = 11

    var result = numbers.first()
    numbers.forEach {
        val countOfDigits = it.getCountOfDigits()
        if (countOfDigits < minCountOfDigits) {
            minCountOfDigits = countOfDigits
            result = it
        }
    }
    return result
}

private fun Int.getCountOfDigits(): Int {
    val countOfDigits = IntArray(10)
    val stringAbsoluteNumber = this.absoluteValue.toString()
    stringAbsoluteNumber.map { it.toString().toInt() }.forEach { countOfDigits[it]++ }

    var result = 0
    countOfDigits.forEach { if (it > 0) result++ }
    return result
}