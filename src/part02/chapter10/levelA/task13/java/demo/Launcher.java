package part02.chapter10.levelA.task13.java.demo;

import java.util.Arrays;
import java.util.LinkedList;

public class Launcher {

    public static void main(String[] args) {
        LinkedList<Double> elements = new LinkedList<Double>(Arrays.asList(1.0, -4.5, 8.0, -2.0, 9.0, 30.0, 25.0, -40.0));
        System.out.println(elements);
        int index = 0;
        int countOfMovedToEnd = 0;
        while (index < elements.size() - countOfMovedToEnd) {
            if (elements.get(index) < 0) {
                elements.addFirst(elements.remove(index));
                index++;
            } else {
                elements.addLast(elements.remove(index));
                countOfMovedToEnd++;
            }
        }
        System.out.println("Result:");
        System.out.println(elements);
    }
}