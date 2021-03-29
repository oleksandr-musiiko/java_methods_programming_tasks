package part02.chapter10.levelA.task16.kotlin.demo

import java.io.File

private const val FILE_PATH = "src/part02/chapter10/levelA/task16/file/text.txt"

fun main() {
    val words = HashSet<String>()
    File(FILE_PATH).inputStream().bufferedReader().useLines { lines ->
        lines.forEach {
            line -> val wordsFromLine = line.split(regex = "[\\s,.–=:?!\"]".toRegex())
            wordsFromLine.filter { word -> word.isNotEmpty() }.forEach { word -> words.add(word.toLowerCase()) }
        }
    }
    println(words)
    println(words.size)
}