package part01.chapter02.levelC.matrix.kotlin

fun cloneMatrix(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val result = Array(matrix.size) { doubleArrayOf()}
    for (rowIndex in matrix.indices) {
        result[rowIndex] = matrix[rowIndex].clone()
    }
    return result
}