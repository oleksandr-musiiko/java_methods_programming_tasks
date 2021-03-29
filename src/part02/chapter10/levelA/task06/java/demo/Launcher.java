package part02.chapter10.levelA.task06.java.demo;

import part02.chapter10.levelA.task06.java.logic.PoemScanner;
import part02.chapter10.levelA.task06.java.model.Poem;

import java.util.Collections;
import java.util.List;

public class Launcher {

    private static final String FILE_PATH = "src/part02/chapter10/levelA/task06/file/BukowskiCharles_poems.txt";

    public static void main(String[] args) {
        PoemScanner poemScanner = new PoemScanner(FILE_PATH);
        List<Poem> bukowskiPoems = poemScanner.scanPoemsFromFile();
        for (Poem bukowskiPoem : bukowskiPoems) {
            System.out.println("'" + bukowskiPoem.getNameOfPoem() + "'" + ",\taverageLength = " + bukowskiPoem.obtainAverageLengthOfLines());
        }
        Collections.sort(bukowskiPoems);
        System.out.println("Sorted poems:");
        for (Poem bukowskiPoem : bukowskiPoems) {
            System.out.println("'" + bukowskiPoem.getNameOfPoem() + "'" + ",\taverageLength = " + bukowskiPoem.obtainAverageLengthOfLines());
        }
    }
}