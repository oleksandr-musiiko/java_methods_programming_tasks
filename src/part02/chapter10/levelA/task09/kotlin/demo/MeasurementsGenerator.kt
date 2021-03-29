package part02.chapter10.levelA.task09.kotlin.demo

import part02.chapter10.levelA.task09.kotlin.model.Amperage
import part02.chapter10.levelA.task09.kotlin.model.Voltage

object MeasurementsGenerator {

    private val firstMeasurementTime = System.currentTimeMillis()
    private const val TIME_STEP = 10

    val amperes = ArrayList<Amperage>().apply {
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.1))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.2))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.3))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.4))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.5))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.6))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.7))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.8))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 0.9))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.0))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.1))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.2))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.3))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.4))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.5))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.6))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.7))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.8))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 1.9))
        add(Amperage(firstMeasurementTime + size * TIME_STEP, 2.0))
    }
    val voltages = ArrayList<Voltage>().apply {
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 0.27))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 0.56))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 0.9))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 1.18))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 1.49))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 1.79))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 2.05))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 2.42))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 2.68))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 3.01))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 3.35))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 3.56))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 3.85))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 4.18))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 4.48))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 4.79))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 5.12))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 5.45))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 5.68))
        add(Voltage(firstMeasurementTime + size * TIME_STEP, 5.9))
    }

}