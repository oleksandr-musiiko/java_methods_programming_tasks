package part01.chapter01.levelA.task05.kotlin.demo

fun main(args: Array<String>) {
    val arrayOfNumbers = args.map { it.toInt() }
    println(arrayOfNumbers.sum())
    var multiplyOfNumbers = 1;
    arrayOfNumbers.forEach{ number -> multiplyOfNumbers *= number}
    println(multiplyOfNumbers)
}