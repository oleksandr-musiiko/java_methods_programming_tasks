package part02.chapter10.levelA.task08.java.demo;

import part02.chapter10.levelA.task08.java.model.CustomSetOfIntegers;

public class Launcher {

    public static void main(String[] args) {
        CustomSetOfIntegers customSetOfIntegers1 = new CustomSetOfIntegers(1, 2, 2, 3, 4, 5);
        CustomSetOfIntegers customSetOfIntegers2 = new CustomSetOfIntegers(3, 5, 6, 7, 8, 8, 8);
        System.out.println(customSetOfIntegers1);
        System.out.println(customSetOfIntegers2);

        System.out.println("intersected: " + customSetOfIntegers1.obtainIntersect(customSetOfIntegers2));
        System.out.println("unify: " + customSetOfIntegers1.unifyToOther(customSetOfIntegers2));
    }
}