package part01.chapter01.levelB.task09.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("ascending order:")
        sortInAscendingOrder(it).forEach { number -> print("$number\t") }
        println("\ndescending order:")
        sortInDescendingOrder(it).forEach { number -> print("$number\t") }
    }
}

private fun sortInAscendingOrder(numbersForSort: IntArray): IntArray {
    val resultArray = numbersForSort.clone()
    for (out in resultArray.size - 1 downTo 1) {
        for (inIndex in 0 until out) {
            if (resultArray[inIndex] > resultArray[inIndex + 1]) {
                val temp = resultArray[inIndex]
                resultArray[inIndex] = resultArray[inIndex + 1]
                resultArray[inIndex + 1] = temp
            }
        }
    }
    return resultArray
}

private fun sortInDescendingOrder(numbersForSort: IntArray): IntArray {
    val resultArray = numbersForSort.clone()
    for (out in resultArray.size - 1 downTo 1) {
        for (inIndex in 0 until out) {
            if (resultArray[inIndex] < resultArray[inIndex + 1]) {
                val temp = resultArray[inIndex]
                resultArray[inIndex] = resultArray[inIndex + 1]
                resultArray[inIndex + 1] = temp
            }
        }
    }
    return resultArray
}