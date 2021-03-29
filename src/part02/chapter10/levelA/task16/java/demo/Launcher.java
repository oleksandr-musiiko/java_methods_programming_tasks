package part02.chapter10.levelA.task16.java.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Launcher {

    private static final String FILE_PATH = "src/part02/chapter10/levelA/task16/file/text.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            Set<String> words = new HashSet<>();
            while (scanner.hasNextLine()) {
                String[] wordsFromLine = scanner.nextLine().split("[\\s,.–=:?!\"]");
                for (String word : wordsFromLine) {
                    if (!word.isEmpty()) {
                        words.add(word.toLowerCase());
                    }
                }
            }
            System.out.println(words);
            System.out.println(words.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}