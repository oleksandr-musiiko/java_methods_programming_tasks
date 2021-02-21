package part01.chapter01.levelB.task14.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println("Numbers that are equal to the half-sum of neighboring elements:")
        for (i in it.indices) {
            val leftIndex = if (i == 0) it.lastIndex else i - 1
            val rightIndex = if (i == it.lastIndex) 0 else i + 1
            if (it[i] == (it[leftIndex] + it[rightIndex]) / 2) {
                print("${it[i]}\t")
            }
        }
    }
}