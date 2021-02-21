package part01.chapter01.levelA.task02.java.demo;

public class Launcher {

    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(args[i]);
                break;
            }
            System.out.println(args[i] + ",\t");
        }
    }

}