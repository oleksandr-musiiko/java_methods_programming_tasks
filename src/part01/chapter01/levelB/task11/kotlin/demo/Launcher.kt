package part01.chapter01.levelB.task11.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader
import kotlin.math.pow

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("Happies numbers:")
        it.filter { number -> isHappyNumber(number) }.forEach { number -> print("$number\t") }
    }
}

private fun isHappyNumber(number: Int): Boolean {
    var visitedTempNumbers = intArrayOf(number)
    var tempNumber = number
    while (true) {
        val sumOfSquaresOfDigits = sumOfSquaresOfDigits(tempNumber)
        if (sumOfSquaresOfDigits == 1) return true
        if (visitedTempNumbers.contains(sumOfSquaresOfDigits)) {
            return false
        } else {
            visitedTempNumbers = visitedTempNumbers.addNumber(sumOfSquaresOfDigits)
            tempNumber = sumOfSquaresOfDigits
        }
    }
}

private fun sumOfSquaresOfDigits(number: Int): Int {
    var tempNumber = number
    var result = 0
    while (tempNumber >= 1) {
        result += (tempNumber % 10).toDouble().pow(2).toInt()
        tempNumber /= 10
    }
    return result
}

private fun IntArray.addNumber(numberForAdd: Int): IntArray {
    val result = this.copyOf(this.size + 1)
    result[result.lastIndex] = numberForAdd
    return result
}