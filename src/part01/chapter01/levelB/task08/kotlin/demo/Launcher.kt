package part01.chapter01.levelB.task08.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader
import kotlin.math.sqrt

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        it.filter { number -> isPrimeNumber(number) }.forEach { number -> print("$number\t") }
    }
}

private fun isPrimeNumber(number: Int): Boolean {
    if (number < 1) return false
    if (number == 1) return true
    val untilNumber = sqrt(number.toDouble()).toInt() + 1
    for (i in 2 until untilNumber) {
        if (number % i == 0) return false
    }
    return true
}