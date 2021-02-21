package part01.chapter01.levelB.task13.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("Palindromic numbers:")
        it.filter { number -> isPalindromicNumber(number) }.forEach { number -> print("$number\t") }
    }
}

private fun isPalindromicNumber(number: Int): Boolean {
    val leftOrderDigits = getDigitsOfNumberFromRightToLeft(number)
    for (i in leftOrderDigits.indices) {
        if (leftOrderDigits[i] != leftOrderDigits[leftOrderDigits.lastIndex - i]) {
            return false
        }
    }
    return true
}

private fun getDigitsOfNumberFromRightToLeft(number: Int): IntArray {
    var tempNumber = number
    var result = IntArray(0)
    while (tempNumber >= 1) {
        val digit = tempNumber % 10
        result = result.addNumberToIntArray(digit)
        tempNumber /= 10
    }
    return result
}

private fun IntArray.addNumberToIntArray(numberForAdd: Int): IntArray {
    val result = this.copyOf(this.size + 1)
    result[result.lastIndex] = numberForAdd
    return result
}