package part02.chapter10.levelA.task02.java.demo;

import java.util.Scanner;
import java.util.Stack;

public class Launcher {

    public static void main(String[] args) {
        double number = readNumber();
        Stack<Character> stack = new Stack<>();
        for (char symbol : Double.toString(number).toCharArray()) {
            stack.push(symbol);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        double result = Double.parseDouble(stringBuilder.toString());
        System.out.println(result);
    }

    private static double readNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}