package part01.chapter02.levelA.console.kotlin

object ConsoleReader {

    fun getArrayOfNumbersFromConsole(): IntArray {
        println("How many Int numbers do you want to input?")
        val countOfNumbers = readLine()?.toInt()
        println("Input $countOfNumbers Int numbers")

        countOfNumbers?.let {
            val result = IntArray(size = it)
            for (i in result.indices) {
                result[i] = readLine()?.toInt()!!
            }
            println("$it numbers was inputted")
            return result
        }
        return IntArray(0)
    }
}