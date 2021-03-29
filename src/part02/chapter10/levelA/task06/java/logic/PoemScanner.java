package part02.chapter10.levelA.task06.java.logic;

import com.sun.media.sound.InvalidDataException;
import part02.chapter10.levelA.task06.file.POEMS_FILE_TAGS;
import part02.chapter10.levelA.task06.java.model.Poem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoemScanner {

    private String filePath;

    public PoemScanner(String filePath) {
        this.filePath = filePath;
    }

    public List<Poem> scanPoemsFromFile() {
        List<Poem> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(POEMS_FILE_TAGS.POEM_BLOCK_START)) {
                    result.add(scanPoemFromFile(reader));
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Poem scanPoemFromFile(BufferedReader reader) throws IOException {
        String title = "";
        StringBuilder poemText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(POEMS_FILE_TAGS.POEM_TITLE)) {
                while (!(line = reader.readLine()).contains(POEMS_FILE_TAGS.POEM_TEXT)) {
                    title += line;
                }
            }
            if (line.contains(POEMS_FILE_TAGS.POEM_TEXT)) {
                while (!(line = reader.readLine()).contains(POEMS_FILE_TAGS.POEM_BLOCK_END)) {
                    poemText.append(line).append("\n");
                }
                return new Poem(title, poemText.toString());
            }
        }
        throw new InvalidDataException();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}