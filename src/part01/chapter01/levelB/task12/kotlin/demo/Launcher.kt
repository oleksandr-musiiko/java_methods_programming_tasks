package part01.chapter01.levelB.task12.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("Fibonacci numbers:")
        it.filter { number -> isFibonacciNumber(number) }.forEach { number -> print("$number\t") }
    }
}

private fun isFibonacciNumber(number: Int): Boolean {
    val gesselNumberWithPlus = 5 * number.toDouble().pow(2) + 4
    val gesselNumberWithMinus = 5 * number.toDouble().pow(2) - 4
    return sqrt(gesselNumberWithPlus).isDoubleWhole() || sqrt(gesselNumberWithMinus).isDoubleWhole()
}

private fun Double.isDoubleWhole() = this % 1 == 0.0