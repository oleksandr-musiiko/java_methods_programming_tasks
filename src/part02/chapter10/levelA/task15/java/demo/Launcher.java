package part02.chapter10.levelA.task15.java.demo;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class Launcher {

    private static final HashMap<Character, Character> escapedCharacters = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }
    };

    public static void main(String[] args) {
        String str1 = "{}([{}()]{})";
        String str2 = "{}([{]()]{})";
        System.out.println(str1 + " = " + isCorrectlyBracketsSpaced(str1));
        System.out.println(str2 + " = " + isCorrectlyBracketsSpaced(str2));
    }

    public static boolean isCorrectlyBracketsSpaced(String str) {
        if (!checkStringSymbols(str)) {
            return false;
        }
        Stack<Character> stackForChecking = new Stack<>();
        for (char ch : str.toCharArray()) {
            Character character = ch;
            if (stackForChecking.isEmpty()) {
                stackForChecking.push(character);
            } else if (character.equals(escapedCharacters.get(stackForChecking.peek()))) {
                stackForChecking.pop();
            } else {
                stackForChecking.push(character);
            }
        }
        return stackForChecking.size() == 0;
    }

    public static boolean checkStringSymbols(String str) {
        return Pattern.matches("[{}\\[\\]()]*", str);
    }
}