package part02.chapter10.levelA.task07.kotlin.demo

import java.util.*

fun main() {
    val stack1 = Stack<String>().apply {
        add("Stack1:first")
        add("Stack1:second")
        add("Stack1:third")
    }
    val stack2 = Stack<String>().apply {
        add("Stack2:first")
        add("Stack2:second")
        add("Stack2:third")
    }
    println("Stack1 = $stack1")
    println("Stack2 = $stack2")


    val elementsOfStack1 = stack1.elements().toList()
    val elementsOfStack2 = stack2.elements().toList()

    stack1.clear()
    stack1.addAll(elementsOfStack2)
    stack2.clear()
    stack2.addAll(elementsOfStack1)

    println("Swapped:")
    println("Stack1 = $stack1")
    println("Stack2 = $stack2")
}