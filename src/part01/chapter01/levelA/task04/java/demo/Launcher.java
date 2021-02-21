package part01.chapter01.levelA.task04.java.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

    public static void main(String[] args) {
        if (args.length > 0) {
            String correctPassword = args[0];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String str = reader.readLine();
                System.out.println(str.equals(correctPassword));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}