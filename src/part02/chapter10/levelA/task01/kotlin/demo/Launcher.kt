package part02.chapter10.levelA.task01.kotlin.demo

import java.io.File

private const val FILE_PATH = "src/part02/chapter10/levelA/task01/file/test.txt"

fun main() {
    val linesFromFile = getLinesFromFile()
    writeLinesToFile(linesFromFile.reversed())
}

private fun writeLinesToFile(linesForWrite: List<String>) {
    File(FILE_PATH).bufferedWriter().use { out ->
        linesForWrite.forEach { line ->
            out.write(line)
            out.newLine()
        }
    }
}

private fun getLinesFromFile(): List<String> {
    val inputStream = File(FILE_PATH).inputStream()

    val result = mutableListOf<String>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { result.add(it) } }
    return result
}