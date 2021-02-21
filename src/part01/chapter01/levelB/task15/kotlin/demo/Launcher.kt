package part01.chapter01.levelB.task15.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        if (it.size < 2) {
            println("Not enough numbers")
            return
        }
        for (i in 0 until it.size - 1) {
            val firstNumber = it[i]
            val secondNumber = it[i + 1]
            if (firstNumber >= 0 && secondNumber >= 1) {
                println("Decimal period of $firstNumber / $secondNumber:")
                getDecimalPeriod(firstNumber, secondNumber).forEach { digit -> print("$digit") }
                return
            }
        }
        println("Numbers satisfying the condition were not found")
    }
}

private fun getDecimalPeriod(firstNumber: Int, secondNumber: Int): IntArray {
    var arrayOfDivisionOperations = IntArray(0)
    var dividend = firstNumber
    while (true) {
        if (arrayOfDivisionOperations.contains(dividend)) {
            var arrayOfDecimalPeriodDigits = IntArray(0)
            for (i in arrayOfDivisionOperations.indexOf(dividend) until arrayOfDivisionOperations.size) {
                val times = arrayOfDivisionOperations[i] / secondNumber
                arrayOfDecimalPeriodDigits = arrayOfDecimalPeriodDigits.addValue(times)
            }
            return arrayOfDecimalPeriodDigits
        } else {
            arrayOfDivisionOperations = arrayOfDivisionOperations.addValue(dividend)
        }
        dividend = (dividend % secondNumber) * 10
    }
}

private fun IntArray.addValue(value: Int): IntArray {
    val result = this.copyOf(this.size + 1)
    result[result.lastIndex] = value
    return result
}