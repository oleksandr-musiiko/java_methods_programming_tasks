package part01.chapter01.levelB.task01.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        numbers.filter { it % 2 == 0 }.forEach { print("$it\t") }
        println()
        numbers.filter { it % 2 != 0 }.forEach { print("$it\t") }
    }
}