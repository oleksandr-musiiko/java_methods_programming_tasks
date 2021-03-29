package part02.chapter10.levelA.task06.java.model;

import org.jetbrains.annotations.NotNull;

public class Poem implements Comparable<Poem> {

    private String nameOfPoem;
    private String textOfPoem;

    public Poem(String nameOfPoem, String textOfPoem) {
        this.nameOfPoem = nameOfPoem;
        this.textOfPoem = textOfPoem;
    }

    public double obtainAverageLengthOfLines() {
        String[] lines = textOfPoem.split("\n");
        int countOfEmptyLines = 0;
        int sumOfLength = 0;
        for (String line : lines) {
            int lineLength = line.length();
            if (lineLength == 0) {
                countOfEmptyLines++;
            } else {
                sumOfLength += lineLength;
            }
        }
        return ((double) sumOfLength) / (lines.length - countOfEmptyLines);
    }

    public String getNameOfPoem() {
        return nameOfPoem;
    }

    public String getTextOfPoem() {
        return textOfPoem;
    }

    @Override
    public String toString() {
        return "Poem: " + nameOfPoem + "\n" + textOfPoem;
    }

    @Override
    public int compareTo(@NotNull Poem o) {
        return (int) (this.obtainAverageLengthOfLines() - o.obtainAverageLengthOfLines());
    }
}