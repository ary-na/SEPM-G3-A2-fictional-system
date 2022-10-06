package main.java.com.sepmg3fs;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

import main.java.com.sepmg3fs.models.Model;

public class FrontEndStaff {

    private final Model backend;

    public FrontEndStaff(Model backend) {
        this.backend = backend;
    }
    public void run() {
        this.ProcessStaffMenu();
    }

    private void ProcessStaffMenu() {
        String selection;
        var exit = false;

        do {
            this.displayStaffMenu();
            selection = getInput("Select an option: ");

            switch (selection) {
                case "1" -> createTicket();
                case "2" -> logout();
                case "3" -> {
                    exit = true;
                    logout();
                }
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }
 // Display staff menu
    private void displayStaffMenu() {

        String menu = """
                                
                Welcome to Cinco System
                                
                [1] Create ticket
                [2] Logout
                """;

        System.out.println(menu);
    }
    
    private void logout() {
        System.out.println("Program loggedout!");
    }
    private void createTicket() {
    	
        System.out.println("Ticket Created");
    }
    
}
