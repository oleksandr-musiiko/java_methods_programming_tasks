package part01.chapter02.levelA.task01.kotlin.demo

import part01.chapter02.levelA.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    if (numbers.isEmpty()) {
        println("Numbers not found")
        return
    }

    val minLengthNumber = getMinLengthNumber(numbers)
    println("Min length number = $minLengthNumber, length = ${minLengthNumber.toString().length}")
    val maxLengthNumber = getMaxLengthNumber(numbers)
    println("Max length number = $maxLengthNumber, length = ${maxLengthNumber.toString().length}")
}

private fun getMinLengthNumber(numbers: IntArray): Int {
    var minLength = Int.MAX_VALUE.toString().length + 1

    var resultNumber = numbers.first()
    numbers.forEach { number->
        val currentNumberLength = number.toString().length
        if (currentNumberLength < minLength) {
            minLength = currentNumberLength
            resultNumber = number
        }
    }
    return resultNumber
}

private fun getMaxLengthNumber(numbers: IntArray): Int {
    var maxLength = 0

    var resultNumber = numbers.first()
    numbers.forEach { number->
        val currentNumberLength = number.toString().length
        if (currentNumberLength > maxLength) {
            maxLength = currentNumberLength
            resultNumber = number
        }
    }
    return resultNumber
}