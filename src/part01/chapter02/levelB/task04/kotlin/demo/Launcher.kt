package part01.chapter02.levelB.task04.kotlin.demo

import part01.chapter02.levelB.task04.kotlin.model.Months

fun main() {
    println("Please, input the Int number of month (from 1 to 12)")
    val number = readInt()

    if (isNumberOfMonthCorrect(number)) {
        println(getMonthByNumber(number))
    } else {
        println("Number is incorrect")
    }
}

private fun getMonthByNumber(number: Int): String {
    return when (number) {
        1 -> Months.JANUARY.text
        2 -> Months.FEBRUARY.text
        3 -> Months.MARCH.text
        4 -> Months.APRIL.text
        5 -> Months.MAY.text
        6 -> Months.JUNE.text
        7 -> Months.JULY.text
        8 -> Months.AUGUST.text
        9 -> Months.SEPTEMBER.text
        10 -> Months.OCTOBER.text
        11 -> Months.NOVEMBER.text
        12 -> Months.DECEMBER.text
        else -> throw IllegalArgumentException("Incorrect number of month: should be from 1 to 12")
    }
}

private fun isNumberOfMonthCorrect(number: Int) = number in 1..12

private fun readInt(): Int {
    val result = readLine()
    return result?.toInt() ?: readInt()
}