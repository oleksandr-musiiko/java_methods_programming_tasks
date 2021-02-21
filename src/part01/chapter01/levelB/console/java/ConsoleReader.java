package part01.chapter01.levelB.console.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public int[] getArrayOfNumbersFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("How many Int numbers do you want to input?");
            int countOfNumbers = Integer.parseInt(reader.readLine());
            System.out.format("Input %d Int numbers" + "\n", countOfNumbers);
            int[] result = new int[countOfNumbers];
            for (int i = 0; i < countOfNumbers; i++) {
                result[i] = Integer.parseInt(reader.readLine());
            }
            System.out.println(countOfNumbers + " numbers was inputed");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
