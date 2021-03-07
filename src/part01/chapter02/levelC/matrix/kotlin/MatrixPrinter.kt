package part01.chapter02.levelC.matrix.kotlin

fun printMatrix(matrix: Array<DoubleArray>) {
    matrix.forEach { row ->
        row.forEach {
            print("$it\t")
        }
        println()
    }
}

fun printMatrix(matrix: Array<LongArray>) {
    matrix.forEach { row ->
        row.forEach {
            print("$it\t")
        }
        println()
    }
}