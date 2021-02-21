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
    for (out in numbersForSort.size - 1 downTo 1) {
        for (inIndex in 0 until out) {
            if (numbersForSort[inIndex] > numbersForSort[inIndex + 1]) {
                val temp = numbersForSort[inIndex]
                numbersForSort[inIndex] = numbersForSort[inIndex + 1]
                numbersForSort[inIndex + 1] = temp
            }
        }
    }
    return numbersForSort
}

private fun sortInDescendingOrder(numbersForSort: IntArray): IntArray {
    for (out in numbersForSort.size - 1 downTo 1) {
        for (inIndex in 0 until out) {
            if (numbersForSort[inIndex] < numbersForSort[inIndex + 1]) {
                val temp = numbersForSort[inIndex]
                numbersForSort[inIndex] = numbersForSort[inIndex + 1]
                numbersForSort[inIndex + 1] = temp
            }
        }
    }
    return numbersForSort
}