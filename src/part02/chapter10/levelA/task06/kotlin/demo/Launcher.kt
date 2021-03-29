package part02.chapter10.levelA.task06.kotlin.demo

import part02.chapter10.levelA.task06.kotlin.logic.PoemScanner

private const val FILE_PATH = "src/part02/chapter10/levelA/task06/file/BukowskiCharles_poems.txt";

fun main() {
    val poemScanner = PoemScanner(FILE_PATH)
    val bukowskiPoems = poemScanner.scanPoemsFromFile()
    bukowskiPoems.forEach { poem -> println("${poem.title},\taverage lines length = ${poem.obtainAverageLengthOfLines()}") }
    println("Sorted:")
    bukowskiPoems.sorted().forEach { poem -> println("${poem.title},\taverage lines length = ${poem.obtainAverageLengthOfLines()}")  }
}