package part02.chapter10.levelA.task09.java.demo;

import part02.chapter10.levelA.task09.java.model.Amperage;
import part02.chapter10.levelA.task09.java.model.Voltage;

import java.util.ArrayList;
import java.util.List;

public final class MeasurementsGenerator {

    private static MeasurementsGenerator instance;

    private final long FIRST_MEASUREMENT_TIME = System.currentTimeMillis();
    private final int TIME_STEP = 5;

    private final List<Amperage> listOfAmperes = new ArrayList<Amperage>() {
        {
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.1));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.2));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.3));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.4));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.5));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.6));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.7));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.8));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.9));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.0));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.1));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.2));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.3));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.4));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.5));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.6));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.7));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.8));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.9));
            add(new Amperage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 2.0));
        }
    };
    private final List<Voltage> listOfVoltages = new ArrayList<Voltage>() {
        {
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.27));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.56));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 0.9));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.18));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.49));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 1.79));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 2.05));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 2.42));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 2.68));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 3.01));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 3.35));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 3.56));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 3.85));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 4.18));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 4.48));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 4.79));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 5.12));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 5.45));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 5.68));
            add(new Voltage(FIRST_MEASUREMENT_TIME + size() * TIME_STEP, 5.9));
        }
    };

    private MeasurementsGenerator() {

    }

    public static MeasurementsGenerator getInstance() {
        if (instance == null) {
            instance = new MeasurementsGenerator();
        }
        return instance;
    }

    public List<Amperage> getListOfAmperes() {
        return listOfAmperes;
    }

    public List<Voltage> getListOfVoltages() {
        return listOfVoltages;
    }
}