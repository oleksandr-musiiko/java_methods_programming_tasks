package part02.chapter10.levelA.task09.java.logic;

import part02.chapter10.levelA.task09.java.model.Amperage;
import part02.chapter10.levelA.task09.java.model.Voltage;

import java.util.List;

public class ResistanceCalculator {

    public Resistance obtainResistance(List<Amperage> amperes, List<Voltage> voltages) {
        if (amperes.size() != voltages.size()) {
            throw new IllegalStateException();
        }
        double approximateResistance = obtainResistanceApproximate(amperes, voltages);
        double measurementErrorValue = calculateMeasurementErrorValue(approximateResistance, amperes, voltages);
        return new Resistance(approximateResistance, measurementErrorValue);
    }

    private double obtainResistanceApproximate(List<Amperage> amperes, List<Voltage> voltages) {
        final int COUNT_OF_MEASUREMENTS = amperes.size();
        double dividend = 0;
        double divider = 0;
        for (int i = 0; i < COUNT_OF_MEASUREMENTS; i++) {
            dividend += voltages.get(i).getVolts() * amperes.get(i).getAmperes();
            divider += Math.pow(amperes.get(i).getAmperes(), 2);
        }
        return dividend / divider;
    }

    private double calculateMeasurementErrorValue(double resistance, List<Amperage> amperes, List<Voltage> voltages) {
        final int COUNT_OF_MEASUREMENTS = amperes.size();
        double dividend = 0;
        double divider = 0;
        for (int i = 0; i < COUNT_OF_MEASUREMENTS; i++) {
            dividend += Math.pow(resistance * amperes.get(i).getAmperes() - voltages.get(i).getVolts(), 2);
            divider += Math.pow(amperes.get(i).getAmperes(), 2);
        }
        return Math.sqrt(dividend / ((COUNT_OF_MEASUREMENTS - 2) * divider));
    }

    private class Resistance {
        private final double resistance;
        private final double measurementErrorValue;

        private Resistance(double resistance, double measurementErrorValue) {
            this.resistance = resistance;
            this.measurementErrorValue = measurementErrorValue;
        }

        public double getResistance() {
            return resistance;
        }

        public double getMeasurementErrorValue() {
            return measurementErrorValue;
        }

        @Override
        public String toString() {
            return "Resistance{" +
                    "resistance=" + resistance +
                    " ±" + measurementErrorValue +
                    '}';
        }
    }
}