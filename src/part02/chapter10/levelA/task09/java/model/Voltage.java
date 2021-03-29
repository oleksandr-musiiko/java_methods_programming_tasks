package part02.chapter10.levelA.task09.java.model;

public class Voltage {

    private final long time;
    private final double volts;

    public Voltage(long time, double volts) {
        this.time = time;
        this.volts = volts;
    }

    public double getVolts() {
        return volts;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Voltage{" +
                "time=" + time +
                ", volts=" + volts +
                '}';
    }
}