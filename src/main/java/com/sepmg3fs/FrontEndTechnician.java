package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.User;
import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;


import java.util.ArrayList;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

public class FrontEndTechnician {

    private Model backend;

    public FrontEndTechnician(Model backend) {
        this.backend = backend;
    }

    public void run() {
        this.processTechnicianMenu();
    }

    private void processTechnicianMenu() {
        String selection;
        var exit = false;

        do {
            this.displayTechnicianMenu();
            selection = getInput("Select an option: ");

            switch (selection) {
                case "1" -> viewAllTickets();
                case "2" -> {
                    exit = true;
                    logout();
                }
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }

    //Display staff menu
    private void displayTechnicianMenu() {
        String menu = """

                Welcome to Cinco System

                [1] View All Tickets
                [2] Logout
                """;

        System.out.println(menu);
    }

    // View all tickets
    private void viewAllTickets() {
        var users = this.backend.getAllUsers();

        String selection;
        var counter = 0;
        var exit = false;

        do {
            for (User staff : users.values()) {
                staff.displayAllTickets(counter);
            }
            selection = getInput("Type ticket description or exit: ");


            for (User staff : users.values()) {
                changeStatus(((Staff) staff).getTickets(), "ticketDescription");
            }


            switch (selection.toLowerCase()) {


                case "exit" -> exit = true;
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }

    public void changeStatus(ArrayList<Ticket> tickets, String ticketDescription) {


    }

    //Logout
    private void logout() {
        this.backend.setCurrentUser(null);
        System.out.println("Program logged-out!");
    }
}
