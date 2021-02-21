package part01.chapter01.levelB.task06.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let { numbers ->
        numbers.filter { isNumberThreeDigit(it) }
                .filter { areAllDigitsDifferentInNumberOfThreeDigits(it) }
                .forEach { print("$it\t") }

    }
}

private fun areAllDigitsDifferentInNumberOfThreeDigits(number: Int): Boolean {
    var digits = arrayOf(-1, -1, -1)
    var temp = number
    var indexOfDigit = 0;
    while (temp >= 1) {
        val currentDigit = temp % 10
        digits.forEach { digit ->
            if (digit == currentDigit) {
                return false
            }
        }
        temp /= 100
        digits[indexOfDigit++] = currentDigit
    }
    return true
}

private fun isNumberThreeDigit(number: Int) = number / 100 in 1..9

