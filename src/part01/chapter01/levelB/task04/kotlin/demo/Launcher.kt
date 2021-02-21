package part01.chapter01.levelB.task04.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let { numbers ->
        numbers.filter { it % 5 == 0 && it % 7 == 0 }.forEach { print("$it,\t") }
    }
}