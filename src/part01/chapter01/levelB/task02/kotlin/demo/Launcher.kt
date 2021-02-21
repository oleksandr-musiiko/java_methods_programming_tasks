package part01.chapter01.levelB.task02.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
            println(numbers.max())
            println(numbers.min())
    }
}