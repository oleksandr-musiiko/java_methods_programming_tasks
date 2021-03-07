package part01.chapter02.levelB.task01.kotlin.demo

import part01.chapter02.levelC.console.kotlin.readDouble
import part01.chapter02.levelC.console.kotlin.readInt

fun main() {
    println("Please input the k-value")
    val k = readDouble()
    println("Please input the Int n")
    val n = readInt()
    println("Please input the Int m")
    val m = readInt()

    println("For k = $k, n = $n, m = $m")
    println("(n,m) = ${k.isInOutMUntilM(n, m)}")
    println("[n,m] = ${k.isInFromNToM(n, m)}")
    println("(n,m] = ${k.isInOutNToM(n, m)}")
    println("[n,m) = ${k.isInFromNUntilM(n, m)}")
}

private fun Double.isInOutMUntilM(n: Int, m: Int) = this > n && this < m

private fun Double.isInFromNToM(n: Int, m: Int) = this >= n && this <= m

private fun Double.isInFromNUntilM(n: Int, m: Int) = this >= n && this < m

private fun Double.isInOutNToM(n: Int, m: Int) = this > n && this <= m