package part01.chapter01.levelB.task03.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let { numbers ->
        numbers.filter { number -> number % 3 == 0 }.forEach { print("$it\t") }
    }
}