package part01.chapter02.levelA.task05.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader
import kotlin.math.absoluteValue

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()

    var countOfNumbersWithAllEvenDigits = 0
    var countOfNumbersWithEqualCountEvenAndOddDigits = 0
    numbers.forEach {
        if (isAllDigitsEven(it)) {
            countOfNumbersWithAllEvenDigits++
        } else if (isCountOfEvenAndOddDigitsEqual(it)) {
            countOfNumbersWithEqualCountEvenAndOddDigits++
        }
    }
    println("Count of numbers, where all digits are even = $countOfNumbersWithAllEvenDigits")
    println("Count of numbers, where count of even digits equals count of odd digits = $countOfNumbersWithEqualCountEvenAndOddDigits")
}

private fun isCountOfEvenAndOddDigitsEqual(number: Int): Boolean {
    var countOfEvenDigits = 0
    var countOfOddDigits = 0
    number.absoluteValue.toString().forEach {
        if (it.toString().toInt() % 2 == 0) countOfEvenDigits++ else countOfOddDigits++
    }
    return countOfEvenDigits == countOfOddDigits
}

private fun isAllDigitsEven(number: Int): Boolean {
    number.absoluteValue.toString().forEach { if (it.toString().toInt() % 2 != 0) return false }
    return true
}