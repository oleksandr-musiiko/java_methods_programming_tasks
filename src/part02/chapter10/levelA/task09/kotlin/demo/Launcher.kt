package part02.chapter10.levelA.task09.kotlin.demo

import part02.chapter10.levelA.task09.kotlin.logic.ResistanceCalculator

fun main() {
    val amperes = MeasurementsGenerator.amperes
    val voltages = MeasurementsGenerator.voltages
    for (i in amperes.indices) {
        println("${amperes[i]}, ${voltages[i]}")
    }
    val resistance = ResistanceCalculator.obtainResistance(amperes, voltages)
    println(resistance)
}