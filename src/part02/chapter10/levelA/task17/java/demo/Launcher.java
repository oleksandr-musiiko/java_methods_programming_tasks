package part02.chapter10.levelA.task17.java.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Launcher {

    private static final String FILE_PATH = "src/part02/chapter10/levelA/task17/file/text.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            HashMap<String, Integer> words = new HashMap<>();
            while (scanner.hasNextLine()) {
                String[] wordsFromLine = scanner.nextLine().split("[\\s,.–=:?!\"]");
                for (String word : wordsFromLine) {
                    if (!word.isEmpty()) {
                        String lowerCaseWord = word.toLowerCase();
                        words.put(lowerCaseWord, words.getOrDefault(lowerCaseWord, 0) + 1);
                    }
                }
            }
            Map<String, Integer> sortedWordsByFrequency = sort(words);
            System.out.println(sortedWordsByFrequency);
            System.out.println(sortedWordsByFrequency.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, Integer> sort(HashMap<String, Integer> hashMap) {
        return hashMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }
}