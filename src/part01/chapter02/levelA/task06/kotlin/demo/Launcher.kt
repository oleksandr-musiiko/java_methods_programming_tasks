package part01.chapter02.levelA.task06.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader
import kotlin.math.absoluteValue

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()

    numbers.forEach {
        if (areDigitsOfNumberInAscendingOrder(it)) {
            println("First number, where digits in ascending order = $it")
            return
        }
    }
    println("Number, where digits in ascending order, not found")
}

private fun areDigitsOfNumberInAscendingOrder(number: Int): Boolean {
    var previousDigit = -1
    number.absoluteValue.toString().map { it.toString().toInt() }.forEach { digit ->
        if (digit <= previousDigit) return false
        previousDigit = digit
    }
    return true
}