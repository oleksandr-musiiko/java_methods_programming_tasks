package part02.chapter10.levelA.task01.java.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Launcher {

    private final static String FILE_PATH = "src/part02/chapter10/levelA/task01/file/test.txt";

    public static void main(String[] args) {
        List<String> lines = readLinesFromFile();
        if (lines == null) {
            return;
        }
        Collections.reverse(lines);
        boolean wasWritingCompleted = writeStringsToFile(lines);
        if (wasWritingCompleted) {
            System.out.println("Writing lines completed successfully ");
        } else {
            System.out.println("Writing lines did not complete ");
        }
    }

    private static boolean writeStringsToFile(List<String> linesForWrite) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(Launcher.FILE_PATH))) {
            for (String line : linesForWrite) {
                fileWriter.write(line);
                fileWriter.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static List<String> readLinesFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Launcher.FILE_PATH))) {
            ArrayList<String> result = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}