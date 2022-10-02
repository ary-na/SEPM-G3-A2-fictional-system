package main.java.com.sepmg3fs;

import java.util.Scanner;

public class FictionalSystemFrontEnd {

    private final Scanner sc;
    private FictionalSystemBackend be;

    public FictionalSystemFrontEnd(FictionalSystemBackend backend) {
        this.sc = new Scanner(System.in);
        this.be = backend;
    }

    public void run() {
        displayMainMenu();
    }

    private void ProcessMenu() {

    }

    // Display main menu
    private void displayMainMenu() {

        String menu = """
                Welcome to Fictional System
                                
                Select from menu:
                [1] Login
                [2] Create account""";

        System.out.println(menu);
    }

    // Print output and return user input
    private String getInput(String output) {
        System.out.print(output);
        return sc.nextLine();
    }
}
