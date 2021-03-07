package part01.chapter02.levelC.task01.kotlin.util

import part01.chapter02.levelC.matrix.kotlin.cloneMatrix

object TimesValueInArrayCounter {

    fun obtainTimesInArrayValueAndCount(array: DoubleArray): Array<DoubleArray> {
        var timesArray = arrayOf(DoubleArray(2))
        array.forEach {
            timesArray = addTimeToTimesArray(timesArray, it)
        }
        return timesArray
    }

    fun getTimes(timesArray: Array<DoubleArray>, number: Double): Int {
        if (containsInTimesArray(timesArray, number)) {
            return timesArray[indexOfTimesArray(timesArray, number)][1].toInt()
        }
        return 0
    }

    fun removeTimeFromTimesArray(timesArray: Array<DoubleArray>, number: Double): Array<DoubleArray> {
        val result = cloneMatrix(timesArray)
        if (containsInTimesArray(result, number)) {
            result[indexOfTimesArray(result, number)][1]--
        }
        return result
    }

    private fun addTimeToTimesArray(timesArray: Array<DoubleArray>, number: Double): Array<DoubleArray> {
        return if (containsInTimesArray(timesArray, number)) {
            val result = cloneMatrix(timesArray)
            result[indexOfTimesArray(timesArray, number)][1]++
            result
        } else {
            val result = Array(timesArray.size + 1) { DoubleArray(2) }
            for (rowIndex in timesArray.indices) {
                result[rowIndex] = timesArray[rowIndex]
            }
            result[result.lastIndex] = doubleArrayOf(number, 1.0)
            result
        }
    }

    private fun containsInTimesArray(timesArray: Array<DoubleArray>, number: Double) = indexOfTimesArray(timesArray, number) != -1

    private fun indexOfTimesArray(timesArray: Array<DoubleArray>, number: Double): Int {
        for (rowIndex in timesArray.indices) {
            if (timesArray[rowIndex][0] == number) {
                return rowIndex
            }
        }
        return -1
    }
}