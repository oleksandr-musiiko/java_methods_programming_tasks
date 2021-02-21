package part01.chapter01.levelB.task07.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("NOD = ${nOD(it)}")
        println("NOK = ${nOK(it)}")
    }
}

private fun nOD(number1: Int, number2: Int): Int {
    var tempNumber1 = number1
    var tempNumber2 = number2
    while (tempNumber1 != 0 && tempNumber2 != 0) {
        if (tempNumber1 > tempNumber2) {
            tempNumber1 %= tempNumber2
        } else {
            tempNumber2 %= tempNumber1
        }
    }
    return tempNumber1 + tempNumber2
}

private fun nOD(numbers: IntArray): Int {
    return when (numbers.size) {
        0 -> 0
        1 -> numbers[1]
        else -> {
            var result = numbers.first()
            for (i in 1 until numbers.size) {
                result = nOD(result, numbers[i])
            }
            result
        }
    }
}

private fun nOK(number1: Int, number2: Int): Int {
    return number1 * number2 / nOD(number1, number2)
}

private fun nOK(numbers: IntArray): Int {
    return when (numbers.size) {
        0 -> 0
        1 -> numbers.first()
        else -> {
            var result = numbers.first()
            for (i in 1 until numbers.size) {
                result = nOK(result, numbers[i])
            }
            result
        }
    }
}