package part02.chapter10.levelA.task15.kotlin.demo

import java.util.*
import java.util.regex.Pattern

private val escapedSymbols = mapOf('{' to '}', '[' to ']', '(' to ')')

fun main() {
    val str1 = "{}([{}()]{})"
    val str2 = "{}([{]()]{})[]"
    println("$str1 are brackets correctly spaced? : ${isCorrectlyBracketsSpaced(str1)}")
    println("$str2 are brackets correctly spaced? : ${isCorrectlyBracketsSpaced(str2)}")
}

private fun isCorrectlyBracketsSpaced(str: String): Boolean {
    if (!str.isAllSymbolsCorrected()) return false
    val stackForChecking = Stack<Char>()
    str.toCharArray().forEach { char ->
        when {
            stackForChecking.isEmpty() -> {
                stackForChecking.push(char)
            }
            char == escapedSymbols[stackForChecking.peek()] -> {
                stackForChecking.pop()
            }
            else -> {
                stackForChecking.push(char)
            }
        }
    }
    return stackForChecking.isEmpty()
}

private fun String.isAllSymbolsCorrected() = Pattern.matches("[{}()\\[\\]]*", this)