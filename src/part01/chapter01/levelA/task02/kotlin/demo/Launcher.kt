package part01.chapter01.levelA.task02.kotlin.demo

fun main(array: Array<String>) {

    for (i: Int in array.size - 1 downTo 0 step 1) {
        if (i==0) {
            print(array[i])
        } else {
            print(array[i] + ",\t")
        }
    }

}