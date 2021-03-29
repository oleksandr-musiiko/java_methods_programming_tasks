package part02.chapter10.levelA.task14.java.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    private static final String FILE_PATH = "src/part02/chapter10/levelA/task14/file/text.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            List<String> linesFromFile = new ArrayList<>();
            while (scanner.hasNext()) {
                linesFromFile.add(scanner.nextLine());
            }
            printLines(linesFromFile);
            Collections.sort(linesFromFile);
            System.out.println("Result:");
            printLines(linesFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}