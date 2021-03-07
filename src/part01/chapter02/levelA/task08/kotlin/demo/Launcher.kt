package part01.chapter02.levelA.task08.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader
import kotlin.math.absoluteValue

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()

    var countOfFounded = 0
    var firstPalindromicNumber: Int? = null
    numbers.forEach {
        if (isPalindromicNumber(it)) {
            countOfFounded++
            when (countOfFounded) {
                1 -> firstPalindromicNumber = it
                2 -> {
                    println("Second palindromic number = $it")
                    return
                }
            }
        }
    }
    if (firstPalindromicNumber != null) {
        println("Only one palindromic number = $firstPalindromicNumber")
    } else {
        println("Palindromic numbers not found")
    }
}

private fun isPalindromicNumber(number: Int): Boolean {
    val digits = number.absoluteValue.toString().map { it.toString().toInt() }
    for (i in digits.indices) {
        if (digits[i] != digits[digits.lastIndex - i]) {
            return false
        }
    }
    return true
}