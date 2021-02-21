package part01.chapter01.levelB.task05.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader
import kotlin.math.abs

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let { numbers ->
        for (out in numbers.size - 1 downTo 1 step 1) {
            for (from in 0 until out) {
                if (abs(numbers[from]) < abs(numbers[from + 1])) {
                    val temp = numbers[from]
                    numbers[from] = numbers[from + 1]
                    numbers[from + 1] = temp
                }
            }
        }
        numbers.forEach { number -> print("$number\t") }
    }
}