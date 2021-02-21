package part01.chapter01.levelA.task03.kotlin.demo

import kotlin.random.Random

fun main(array: Array<String>) {
    if (array.isNotEmpty()) {
        val countOfNumbers = array[0].toInt()
        for (i in 0..countOfNumbers) {
            println(Random.nextInt())
        }
        for (i in 0..countOfNumbers) {
            print("${Random.nextInt()}\t")
        }
    }
}