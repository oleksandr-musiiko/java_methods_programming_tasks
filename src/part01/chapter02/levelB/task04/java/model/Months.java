package part01.chapter02.levelB.task04.java.model;

public enum Months {
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    private final String text;

    Months(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}