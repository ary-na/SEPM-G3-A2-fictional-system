package main.java.com.sepmg3fs.utilities;

import java.util.Scanner;

public class UtilityMethods {
    private static final Scanner sc = new Scanner(System.in);

    // Print output and return user input
    public static String getInput(String output) {
        System.out.print(output);
        return sc.nextLine();
    }

    private static long idCounter = 0;

    //Generate unique ID
    public static synchronized String createID() {
        return String.valueOf(++idCounter);
    }
}
