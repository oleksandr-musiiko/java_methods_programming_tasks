package part01.chapter01.levelB.task10.kotlin.demo

import part01.chapter01.levelB.console.kotlin.ConsoleReader

fun main() {
    val numbers = ConsoleReader.getArrayOfNumbersFromConsole()
    numbers?.let {
        println()
        sortInDescendingOrderOfOccurrence(it).forEach { number -> print("$number\t") }
    }

}

private fun sortInDescendingOrderOfOccurrence(numbers: IntArray): IntArray {
    val arrayOfDifferentNumbers = arrayOfDifferentNumbers(numbers)
    val matrix = matrixCountOfDifferentNumbersArray(numbers = numbers, differentNumbers = arrayOfDifferentNumbers)
    var result = IntArray(numbers.size)
    var resultArrayIndex = 0
    for (countMatrixIndex in matrix.size - 1 downTo 0) {
        for (numberMatrixIndex in matrix[countMatrixIndex].indices) {
            if (matrix[countMatrixIndex][numberMatrixIndex] == null) {
                break
            }
            val numberForSaveToResultArray = matrix[countMatrixIndex][numberMatrixIndex]
            for (i in 0 until countMatrixIndex) {
                numberForSaveToResultArray?.let {
                    result[resultArrayIndex] = numberForSaveToResultArray
                    resultArrayIndex++
                }
            }
        }
    }
    return result
}

private fun matrixCountOfDifferentNumbersArray(numbers: IntArray, differentNumbers: IntArray): Array<Array<Int?>> {
    val result = Array(numbers.size) { arrayOfNulls<Int>(differentNumbers.size) }
    differentNumbers.forEach { unicNumber ->
        var countOfUnicNumberInNumbers = 0
        numbers.forEach { if (unicNumber == it) countOfUnicNumberInNumbers++ }
        for (indexOfUnicNumberForSave in differentNumbers.indices) {
            if (result[countOfUnicNumberInNumbers][indexOfUnicNumberForSave] == null) {
                result[countOfUnicNumberInNumbers][indexOfUnicNumberForSave] = unicNumber
                break
            }
        }
    }
    return result
}

private fun arrayOfDifferentNumbers(numbersArray: IntArray): IntArray {
    val tempArray = arrayOfNulls<Int>(numbersArray.size)
    var differentNumbersSize = 0
    for (i in numbersArray.indices) {
        val number = numbersArray[i]
        for (tempArrayIndex in tempArray.indices) {
            if (tempArray[tempArrayIndex] == null) {
                tempArray[tempArrayIndex] = number
                differentNumbersSize++
                break
            }
            if (tempArray[tempArrayIndex] == number) break
        }
    }
    val resultArray = IntArray(differentNumbersSize)
    for (i in 0 until differentNumbersSize) {
        tempArray[i]?.let {
            resultArray[i] = it
        }
    }
    return resultArray
}