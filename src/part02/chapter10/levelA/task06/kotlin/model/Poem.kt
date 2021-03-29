package part02.chapter10.levelA.task06.kotlin.model

data class Poem(val title: String, val text: String) : Comparable<Poem> {

    fun obtainAverageLengthOfLines(): Double {
        val lines = text.split("\n")
        var sumOfLengthOfLines = 0
        var countOfEmptyLines = 0
        lines.forEach { line ->
            if (line.isEmpty()) countOfEmptyLines++ else sumOfLengthOfLines += line.length
        }
        return sumOfLengthOfLines.toDouble() / (lines.size - countOfEmptyLines)
    }

    override fun compareTo(other: Poem): Int {
        return (this.obtainAverageLengthOfLines() - other.obtainAverageLengthOfLines()).toInt()
    }
}