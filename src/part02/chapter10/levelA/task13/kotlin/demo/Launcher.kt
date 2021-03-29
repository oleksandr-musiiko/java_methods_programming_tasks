package part02.chapter10.levelA.task13.kotlin.demo

import java.util.*

fun main() {
    val elements = LinkedList<Double>(listOf(7.0, -2.3, -4.6, 5.0, 80.0, -4.2, 45.0, -1.5))
    println(elements)
    var index = 0
    var countOfMovedToEnd = 0
    while (index < elements.size - countOfMovedToEnd) {
        if (elements[index] < 0) {
            elements.addFirst(elements.removeAt(index))
            index++
        } else {
            elements.addLast(elements.removeAt(index))
            countOfMovedToEnd++
        }
    }
    println("Result:")
    println(elements)
}