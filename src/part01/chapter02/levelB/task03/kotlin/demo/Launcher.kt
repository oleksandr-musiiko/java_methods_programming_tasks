package part01.chapter02.levelB.task03.kotlin.demo

import part01.chapter02.levelC.console.kotlin.readDouble
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println("a * x^2 + b * x + c = 0")
    println("Please, input a-value != 0")
    val a = readDouble()
    if (a == 0.0) return
    println("Please, input b-value")
    val b = readDouble()
    println("Please, input c-value")
    val c = readDouble()

    println("a * x^2 + b * x + c = 0, where a = $a ; b = $b ; c = $c :")
    val roots = obtainRootsOfTheEquation(a, b, c)
    when (roots.size) {
        0 -> println("Equation doesn't have roots")
        1 -> println("Only one root of equation = ${roots.first()}")
        2 -> println("First root = ${roots[0]}, second root = ${roots[1]}")
        else -> System.err.println("Equation cannot have more then 2 roots")
    }
}

private fun obtainRootsOfTheEquation(a: Double, b: Double, c: Double): DoubleArray {
    val discriminant = b.pow(2) - 4 * a * c
    return when {
        discriminant < 0 -> {
            DoubleArray(0)
        }
        discriminant == 0.0 -> {
            val root = -(b / (2 * a))
            doubleArrayOf(root)
        }
        else -> {
            val firstRoot = (-b + sqrt(discriminant)) / (2 * a)
            val secondRoot = (-b - sqrt(discriminant)) / (2 * a)
            doubleArrayOf(firstRoot, secondRoot)
        }
    }
}