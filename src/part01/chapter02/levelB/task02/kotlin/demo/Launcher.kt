package part01.chapter02.levelB.task02.kotlin.demo

import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val k = readK()
    val matrix = getSquareMatrixFromOneToK(k)
    println("Matrix from 1 to K:")
    printMatrix(matrix)
}

private fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach { row ->
        row.forEach {
            if (it == 0) print("_\t") else print("$it\t")
        }
        println()
    }
}

private fun getSquareMatrixFromOneToK(k: Int): Array<IntArray> {
    val sqrtK = sqrt(k.toDouble())
    val n = (if (sqrtK % 1 == 0.0) sqrtK else ceil(sqrtK)).toInt()

    val result = Array(n) { IntArray(n) }
    val lastIndex = n - 1
    var rowIndex = 0
    var indexOfElementInRow = 0
    for (i in 1..k) {
        result[rowIndex][indexOfElementInRow] = i
        if (indexOfElementInRow == lastIndex) {
            rowIndex++
            indexOfElementInRow = 0
        } else {
            indexOfElementInRow++
        }
    }
    return result
}

private fun readK(): Int {
    println("Please input Int k-value")
    val k = readLine()?.toInt()
    return k ?: readK()
}