package part02.chapter10.levelA.task10.kotlin.demo

fun main() {
    val linkedSet = linkedSetOf(1, 4, 7, 2, 15, -10, 8, 2)
    println(linkedSet)
    while (linkedSet.size > 1) {
        val values = linkedSet.toTypedArray()

        for (i in 1 until values.size) {
            linkedSet.remove(values[i - 1])
            linkedSet.remove(values[i])
            linkedSet.add(values[i - 1] + values[i])
        }

        println(linkedSet)
    }
}