package part02.chapter10.levelA.task02.kotlin.demo

import part02.chapter10.levelA.task02.kotlin.stack.MutableStack

fun main() {
    val number = readDouble()
    val stack = MutableStack<Char>().apply {
        number.toString().toCharArray().forEach { push(it) }
    }
    val stringOfResultNumber = StringBuilder()
    while (!stack.isEmpty()) {
        stringOfResultNumber.append(stack.pop())
    }
    val result = stringOfResultNumber.toString().toDouble()
    println(result)
}

private fun readDouble(): Double = readLine()?.toDouble() ?: readDouble()


