package part02.chapter10.levelA.task10.java.demo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {
        Set<Integer> linkedHashSet = new LinkedHashSet(Arrays.asList(1, 4, 7, 10, 3, 15, 45, 20, 35));
        System.out.println(linkedHashSet);
        while (linkedHashSet.size() > 1) {
            Integer[] values = new Integer[linkedHashSet.size()];
            values = linkedHashSet.toArray(values);

            for (int i = 1; i < values.length; i++) {
                linkedHashSet.remove(values[i - 1]);
                linkedHashSet.remove(values[i]);
                linkedHashSet.add(values[i - 1] + values[i]);
            }

            System.out.println(linkedHashSet);
        }
    }
}