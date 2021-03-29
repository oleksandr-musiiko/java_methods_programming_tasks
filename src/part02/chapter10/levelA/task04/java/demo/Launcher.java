package part02.chapter10.levelA.task04.java.demo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Launcher {

    private static final String DIRECTORY_PATH = "src";

    public static void main(String[] args) {
        List<File> listOfDirectoryAndSubdirectoryItems = getFilesOfDirectory(new File(DIRECTORY_PATH));
        for (File file : listOfDirectoryAndSubdirectoryItems) {
            System.out.println(file.getPath());
        }
    }

    private static List<File> getFilesOfDirectory(final File directory) {
        List<File> result = new LinkedList<>();
        fillFilesOfDirectoryToList(result, directory);
        return result;
    }

    private static void fillFilesOfDirectoryToList(List<File> list, final File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles == null) {
            return;
        }
        for (final File fileEntry : listOfFiles) {
            if (fileEntry.isDirectory()) {
                fillFilesOfDirectoryToList(list, fileEntry);
            } else {
                list.add(fileEntry);
            }
        }
    }
}