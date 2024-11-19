package util;

import java.util.Scanner;

public class Util {

    private static final Scanner sc = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print("\u001B[35m"+">>" +prompt);
        return sc.next();
    }
    public static int getIntInput(String prompt) {
        System.out.print("\u001B[35m"+">>" +prompt);
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }
}
