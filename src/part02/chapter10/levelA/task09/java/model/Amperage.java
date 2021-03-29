package part02.chapter10.levelA.task09.java.model;

public class Amperage {

    private final long time;
    private final double amperes;

    public Amperage(long time, double amperes) {
        this.time = time;
        this.amperes = amperes;
    }

    public double getAmperes() {
        return amperes;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Amperage{" +
                "time=" + time +
                ", amperes=" + amperes +
                '}';
    }
}