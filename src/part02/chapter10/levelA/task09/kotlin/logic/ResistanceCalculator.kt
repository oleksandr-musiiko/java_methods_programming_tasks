package part02.chapter10.levelA.task09.kotlin.logic

import part02.chapter10.levelA.task09.kotlin.model.Amperage
import part02.chapter10.levelA.task09.kotlin.model.Voltage
import kotlin.math.pow
import kotlin.math.sqrt

object ResistanceCalculator {

    fun obtainResistance(amperes: List<Amperage>, voltages: List<Voltage>): Resistance {
        if (amperes.size != voltages.size) throw IllegalArgumentException()
        val approximateResistance = obtainResistanceApproximate(amperes = amperes, voltages = voltages)
        val measurementErrorValue = calculateMeasurementErrorValue(
                resistance = approximateResistance,
                amperes = amperes,
                voltages = voltages
        )
        return Resistance(approximateResistance, measurementErrorValue)
    }

    private fun obtainResistanceApproximate(amperes: List<Amperage>, voltages: List<Voltage>): Double {
        val countOfMeasurement = amperes.size
        var dividend = 0.0
        var divider = 0.0
        for (i in 0 until countOfMeasurement) {
            dividend += amperes[i].amperes * voltages[i].voltages
            divider += amperes[i].amperes.pow(2)
        }
        return dividend / divider
    }

    private fun calculateMeasurementErrorValue(resistance: Double, amperes: List<Amperage>, voltages: List<Voltage>): Double {
        val countOfMeasurement = amperes.size
        var dividend = 0.0
        var divider = 0.0
        for (i in 0 until countOfMeasurement) {
            dividend += (resistance * amperes[i].amperes - voltages[i].voltages).pow(2)
            divider += amperes[i].amperes.pow(2)
        }
        return sqrt(dividend / (divider * (countOfMeasurement - 2)))
    }

    data class Resistance(val resistance: Double, val measurementErrorValue: Double) {
        override fun toString(): String {
            return "Resistance(resistance=$resistance ±$measurementErrorValue)"
        }
    }
}