package part02.chapter10.levelA.task08.kotlin.demo

import part02.chapter10.levelA.task08.java.model.CustomSetOfIntegers

fun main() {
    val customSetOfIntegers1 = CustomSetOfIntegers(1, 2, 3, 3, 2, 4, 5, 5)
    val customSetOfIntegers2 = CustomSetOfIntegers(3, 3, 5, 5, 5, 5, 7)
    println(customSetOfIntegers1)
    println(customSetOfIntegers2)

    println("intersected: ${customSetOfIntegers1.obtainIntersect(customSetOfIntegers2)}")
    println("unify: ${customSetOfIntegers1.unifyToOther(customSetOfIntegers2)}")
}