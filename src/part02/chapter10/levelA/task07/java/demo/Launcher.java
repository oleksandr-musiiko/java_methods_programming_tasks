package part02.chapter10.levelA.task07.java.demo;

import java.util.*;

public class Launcher {

    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<String>(){
            {
                add("Stack1:first");
                add("Stack1:second");
                add("Stack1:third");
            }
        };
        Stack<String> stack2 = new Stack<String>(){
            {
                add("Stack2:first");
                add("Stack2:second");
                add("Stack2:third");
            }
        };
        System.out.println("Stack1 = " + stack1);
        System.out.println("Stack2 = " + stack2);

        List<String> elementsOfStack1 = new ArrayList<>(stack1);
        List<String> elementsOfStack2 = new ArrayList<>(stack2);

        stack1.clear();
        stack1.addAll(elementsOfStack2);
        stack2.clear();
        stack2.addAll(elementsOfStack1);

        System.out.println("Swapped:");
        System.out.println("Stack1 = " + stack1);
        System.out.println("Stack2 = " + stack2);
    }
}