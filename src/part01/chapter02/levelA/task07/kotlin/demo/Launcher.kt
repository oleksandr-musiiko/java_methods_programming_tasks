package part01.chapter02.levelA.task07.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader
import kotlin.math.absoluteValue

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()

    numbers.forEach {
        if (isAllDigitsDifferent(it)) {
            println("First number, where all digits are different = $it")
            return
        }
    }
    println("Number, where all digits are different, not found")
}

private fun isAllDigitsDifferent(number: Int): Boolean {
    val countOfDigits = IntArray(10)

    number.absoluteValue.toString().map { it.toString().toInt() }.forEach { countOfDigits[it]++ }
    countOfDigits.forEach { if (it > 1) return false }
    return true
}