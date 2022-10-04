package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Backend;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

public class FrontEndMain {
    private Backend be;

    public FrontEndMain(Backend backend) {
        this.be = backend;
    }

    public void run() {
        this.ProcessMainMenu();
    }

    private void ProcessMainMenu() {
        String selection;
        var exit = false;

        do {
            this.displayMainMenu();
            selection = getInput("Select an option: ");

            switch (selection) {
                case "1" -> login();
                case "2" -> createAccount();
                case "3" -> {
                    exit = true;
                    exit();
                }
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }

    private void login() {
        System.out.println("login");
    }

    private void createAccount() {

        // Validate email address
        String emailAddress = getInput("Enter your email address: ");
        while (this.be.validateEmail(emailAddress)) {
            System.out.println("\n** error ** Email address already exists, try again!\n");
            emailAddress = getInput("Enter your email address: ");
        }

        String fullName = getInput("Enter your full name: ");

        // Validate phone number
        String phoneNumber = getInput("Enter your phone number: ");
        while (!this.be.validatePhoneNumber(phoneNumber)) {
            System.out.println("\n** error ** Invalid phone number, try again!\n");
            phoneNumber = getInput("Enter your phone number: ");
        }

        // Validate password
        String password = getInput("Enter a password: ");
        while (!this.be.validatePassword(password)) {
            System.out.println("\n** error ** Password must contain a mix of uppercase and lowercase alphanumeric characters of min length 20, try again!\n");
            password = getInput("Enter a password: ");
        }

        this.be.createAccount(emailAddress, fullName, phoneNumber, password);
    }

    private void exit() {
        System.out.println("Program ending!");
    }

    // Display main menu
    private void displayMainMenu() {

        String menu = """
                                
                Welcome to Fictional System
                                
                [1] Login
                [2] Create account
                [3] Exit
                """;

        System.out.println(menu);
    }
}
