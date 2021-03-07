package part01.chapter02.levelC.matrix.kotlin

import part01.chapter02.levelC.console.kotlin.readInt
import kotlin.random.Random

object MatrixCreator {

    fun getSquareMatrix(): Array<DoubleArray> {
        println("Please input N-value for matrix N*N, N should be equals or more 1")
        val n = readInt()
        if (n <= 1) {
            println("Incorrect N: N should be equals or more 1")
            return getSquareMatrix()
        }

        val result = Array(n) { DoubleArray(n) }
        for (rowIndex in result.indices) {
            for (columnIndex in result[rowIndex].indices) {
                result[rowIndex][columnIndex] = Random.nextDouble(-n.toDouble(), n.toDouble())
            }
        }

        printGeneratedSquareMatrix(result)
        return result
    }

    private fun printGeneratedSquareMatrix(squareMatrix: Array<DoubleArray>) {
        println("Matrix generated:")
        printMatrix(squareMatrix)
    }

}