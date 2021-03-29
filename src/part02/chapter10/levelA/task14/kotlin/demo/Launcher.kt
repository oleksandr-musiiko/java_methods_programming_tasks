package part02.chapter10.levelA.task14.kotlin.demo

import java.io.File

private const val FILE_PATH = "src/part02/chapter10/levelA/task14/file/text.txt"

fun main() {
    val linesFromFile = getLinesFromFile(FILE_PATH)
    printLines(linesFromFile)
    println("Result:")
    printLines(linesFromFile.sorted())
}

private fun getLinesFromFile(filePath: String): List<String> {
    val result = mutableListOf<String>()

    File(filePath).inputStream().bufferedReader().useLines {
        lines -> lines.forEach { line -> result.add(line) }
    }
    return result
}

private fun printLines(lines: List<String>) {
    lines.forEach { line -> println(line) }
}