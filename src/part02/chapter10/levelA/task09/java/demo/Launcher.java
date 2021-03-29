package part02.chapter10.levelA.task09.java.demo;

import part02.chapter10.levelA.task09.java.logic.ResistanceCalculator;
import part02.chapter10.levelA.task09.java.model.Amperage;
import part02.chapter10.levelA.task09.java.model.Voltage;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        List<Amperage> amperes = MeasurementsGenerator.getInstance().getListOfAmperes();
        List<Voltage> voltages = MeasurementsGenerator.getInstance().getListOfVoltages();
        ResistanceCalculator resistanceCalculator = new ResistanceCalculator();
        System.out.println(resistanceCalculator.obtainResistance(amperes, voltages));
    }

}