package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

public class FrontEndMain {
    private final Model backend;

    public FrontEndMain(Model backend) {
        this.backend = backend;
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
                case "3" -> resetPassword();
                case "4" -> {
                    exit = true;
                    exit();
                }
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }

    private void login() {

        String emailAddress = getInput("Enter your email address: ");
        String password;
        do {
            password = getInput("Enter a password: ");
        } while (!this.backend.validatePassword(password));

        var authorised = this.backend.verifyLogin(emailAddress, password);

        // Validate user login details and display appropriate view
        if (authorised && this.backend.getCurrentUser().getClass().getName().equals(Staff.class.getName())) {
            var frontEndStaff = new FrontEndStaff(backend);
            frontEndStaff.run();
        } else {
            var frontEndTechnician = new FrontEndTechnician(backend);
            frontEndTechnician.run();
        }
    }

    private void createAccount() {

        // Validate email address
        String emailAddress = getInput("Enter your email address: ");
        while (this.backend.validateEmail(emailAddress)) {
            System.out.println("\n** error ** Email address already exists, try again!\n");
            emailAddress = getInput("Enter your email address: ");
        }

        String fullName = getInput("Enter your full name: ");

        // Validate phone number
        String phoneNumber = getInput("Enter your phone number: ");
        while (!this.backend.validatePhoneNumber(phoneNumber)) {
            System.out.println("\n** error ** Invalid phone number, try again!\n");
            phoneNumber = getInput("Enter your phone number: ");
        }

        // Validate password
        String password = getInput("Enter a password: ");
        while (!this.backend.validatePassword(password)) {
            System.out.println("\n** error ** Password must contain a mix of uppercase and lowercase alphanumeric characters of min length 20, try again!\n");
            password = getInput("Enter a password: ");
        }

        this.backend.createAccount(emailAddress, fullName, phoneNumber, password);
        System.out.println("\nAccount created! You may now login.");
    }

    private void resetPassword() {
        System.out.println("Please enter all details pertinent to your account to verify your identity (Case Sensitive).");
        String emailAddress = getInput("Enter your Email Address: ");

        // Ensures a valid email is entered
        while (!this.backend.validateEmail(emailAddress)) {
            System.out.println("\n** error ** The email address does not match, try again!\n");
            emailAddress = getInput("Enter your email address: ");
        }

        System.out.println("Please enter a new password below. Once confirmed you will be returned to main menu.");
        System.out.println();
        String newPassword = getInput("New password: ");

        this.backend.changePassword(emailAddress, newPassword);
    }

    private void exit() {
        System.out.println("Program ending!");
    }

    // Display main menu
    private void displayMainMenu() {

        String menu = """
                                
                Welcome to Cinco System
                                
                [1] Login
                [2] Create account
                [3] Reset Password
                [4] Exit
                """;

        System.out.println(menu);
    }
}
