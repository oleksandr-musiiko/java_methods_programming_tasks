package part01.chapter01.levelA.task05.java.demo;

public class Launcher {

    public static void main(String[] args) {
        int[] numbers = new int[args.length];
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
        }
        System.out.println(sumOfElementsOfArray(numbers));
        System.out.println(multiplyOfElementsOfArray(numbers));
    }

    private static int sumOfElementsOfArray(int[] array) {
        int result = 0;
        for (int element :
                array) {
            result += element;
        }
        return result;
    }

    private static int multiplyOfElementsOfArray(int[] array) {
        int result = 1;
        for (int element : array) {
            result *= element;
        }
        return result;
    }

}
