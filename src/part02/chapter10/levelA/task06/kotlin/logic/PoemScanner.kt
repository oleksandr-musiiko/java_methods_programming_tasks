package part02.chapter10.levelA.task06.kotlin.logic

import part02.chapter10.levelA.task06.file.POEMS_FILE_TAGS
import part02.chapter10.levelA.task06.kotlin.model.Poem
import java.io.BufferedReader
import java.io.File

class PoemScanner(var filePath: String) {

    fun scanPoemsFromFile(): List<Poem> {
        val result = mutableListOf<Poem>()
        val bufferedReader = File(filePath).inputStream().bufferedReader()
        while (true) {
            val poem = scanPoemFromFile(bufferedReader)
            if (poem != null) result.add(poem) else return result
        }
    }

    private fun scanPoemFromFile(bufferedReader: BufferedReader): Poem? {
        var poemTitle = ""
        val poemText = StringBuilder()
        var line: String = bufferedReader.readLine() ?: return null
        while (!line.contains(POEMS_FILE_TAGS.POEM_BLOCK_START)) {
            line = bufferedReader.readLine() ?: return null
        }
        while (!line.contains(POEMS_FILE_TAGS.POEM_TITLE)) {
            line = bufferedReader.readLine() ?: return null
        }
        line = bufferedReader.readLine() ?: return null
        while (!line.contains(POEMS_FILE_TAGS.POEM_TEXT)) {
            poemTitle += line
            line = bufferedReader.readLine() ?: return null
        }
        line = bufferedReader.readLine() ?: return null
        while (!line.contains(POEMS_FILE_TAGS.POEM_BLOCK_END)) {
            poemText.append(line).append("\n")
            line = bufferedReader.readLine() ?: return null
        }
        return Poem(poemTitle, poemText.toString())
    }
}