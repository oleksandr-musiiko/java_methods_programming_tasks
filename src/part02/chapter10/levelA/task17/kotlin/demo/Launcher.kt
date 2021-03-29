package part02.chapter10.levelA.task17.kotlin.demo

import java.io.File

private const val FILE_PATH = "src/part02/chapter10/levelA/task17/file/text.txt"

fun main() {
    val wordsFrequency = HashMap<String, Int>()
    File(FILE_PATH).inputStream()
            .bufferedReader()
            .useLines { lines ->
                lines.forEach { line ->
                    val wordsFromLine = line.split("[\\s,.–=:?!\"]".toRegex())
                    wordsFromLine
                            .filter { word -> word.isNotEmpty() }
                            .map { word -> word.toLowerCase() }
                            .forEach { wordInLowerCase -> wordsFrequency[wordInLowerCase] = wordsFrequency.getOrDefault(wordInLowerCase, 0) + 1 }
                }
            }
    val sortedByFrequencyMap = wordsFrequency.toList()
            .sortedByDescending { pair: Pair<String, Int> -> pair.second }
            .toMap()
    println(sortedByFrequencyMap)
    println(sortedByFrequencyMap.size)
}