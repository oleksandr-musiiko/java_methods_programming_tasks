package part02.chapter10.levelA.task04.kotlin.demo

import java.io.File

private const val DIRECTORY_PATH = "src"

fun main() {
    val listOfFiles = getListOfFilesByDirectory(File(DIRECTORY_PATH))
    listOfFiles.forEach { file -> println(file.absolutePath) }
}

private fun getListOfFilesByDirectory(directory: File): List<File> {
    val result = mutableListOf<File>()
    fillFilesOfDirectoryToList(directory, result)
    return result
}

private fun fillFilesOfDirectoryToList(directory: File, listOfFiles: MutableList<File>) {
    directory.listFiles()?.forEach { file ->
        if (file.isDirectory) fillFilesOfDirectoryToList(file, listOfFiles) else listOfFiles.add(file)
    }
}