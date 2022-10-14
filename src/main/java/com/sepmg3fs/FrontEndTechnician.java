package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.User;
import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;


import java.util.ArrayList;
import java.util.Objects;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

public class FrontEndTechnician {

    private final Model backend;

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

    //Display ticket menu
    private void displayTicketMenu() {
        String menu = """

                What would you like to do with this ticket

                [1] Change Severity
                [2] Change Status
                [3] Back to last Menu
                """;

        System.out.println(menu);
    }

    // View all and select a ticket
    private void viewAllTickets() {
        var users = this.backend.getAllUsers();

        var input = "";

        var exit = true;

        do {
            // Exit if no ticket created
            for (User staff : users.values()) {
                if (staff instanceof Staff && (((Staff) staff).getTickets().stream().findAny().isPresent())) {
                    staff.displayAllTickets();
                    exit = false;
                } else if (exit) {
                    System.out.println("No tickets created!");
                    return;
                }
            }

            input = getInput("Type ticket ID or exit: ");

            //If selection is invalid or exit follow path below
            if (input.equals("exit")) {
                exit = true;
            } else {
                //Get users selection and load ticket menu for selected ticket  if selection valid
                for (User staff : users.values()) {
                    //Only casting if user is staff and not technicians
                    if (staff instanceof Staff) {
                        exit = processTicketMenu(((Staff) staff).getTickets(), input.toLowerCase());
                        if (exit)
                            break;
                    }
                }
            }
        }
        while (!exit);
    }

    private boolean processTicketMenu(ArrayList<Ticket> tickets, String Id) {
        String selection;
        var exit = false;

        this.displayTicketMenu();
        selection = getInput("Select an option: ");

        do {
            switch (selection) {
                case "1" -> changeSeverity(tickets, Id);
                case "2" -> changeStatus(tickets, Id);
                case "3" -> exit = true;
                default -> System.err.println("\nSelect a valid menu option\n");
            }
        } while (!exit);
        return true;
    }


    public void changeStatus(ArrayList<Ticket> tickets, String Id) {

        for (Ticket item : tickets) {
            if (item.getId().equals(Id)) {
                // Change status here
                // get input
                // use switch statement to find out what status user entered
                // set the status


                System.out.println("Status changed on ticket " + Id);
            }
        }
    }

    public void changeSeverity(ArrayList<Ticket> tickets, String Id) {


    }

    //Logout
    private void logout() {
        this.backend.setCurrentUser(null);
        System.out.println("Program logged-out!");
    }
}
