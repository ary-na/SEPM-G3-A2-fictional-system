package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.User;
import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;


import java.util.ArrayList;
import java.util.HashMap;
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

    // Display staff menu
    private void displayTechnicianMenu() {
        String menu = """

                Welcome to Cinco System

                [1] View All Tickets
                [2] Logout
                """;

        System.out.println(menu);
    }

    // Display ticket menu
    private void displayTicketMenu() {
        String menu = """

                What would you like to do with this ticket

                [1] Change Severity
                [2] Change Status
                [3] Back to last Menu
                """;

        System.out.println(menu);
    }

    // Display severity menu
    private void displaySeverityMenu() {
        String menu = """
                    			
                Please select the new severity level for the chosen ticket
                    			
                [1] Low
                [2] Medium
                [3] High
                """;

        System.out.println(menu);
    }
    
        // Display severity menu
    private void displayStatusMenu() {
        String menu = """
                    			
                Please select the new status for the chosen ticket
                    			
                [1] Open
                [2] Closed and Resolved
                [3] Closed and Unresolved
                [4] Archived
                """;

        System.out.println(menu);
    }

    // Display post-severity/post-status menu
    private void displayReturnMenu() {
        String menu = """
                    			
                Where would you like to be returned to? 
                    			
                [1] Technician Menu
                [2] Ticket Menu
                [3] Logout
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
                if (staff instanceof Staff) {
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
                exit = processTicketMenu(users, input.toLowerCase());
                if (exit)
                    break;
            }
        }
        while (!exit);
    }

    private boolean processTicketMenu(HashMap<String, User> users, String Id) {

        String selection;
        var exit = false;

        this.displayTicketMenu();
        selection = getInput("Select an option: ");

        do {
            switch (selection) {
                case "1" -> changeSeverity(users, Id);
                case "2" -> changeStatus(users, Id);
                case "3" -> exit = true;
                default -> System.err.println("\nSelect a valid menu option\n");
            }
        } while (!exit);
        return true;
    }


    public void changeStatus(HashMap<String, User> users, String Id) {
      this.displayStatusMenu();  // show status selection menu
      
      String selection = getInput("Select an option: ");  // get input then determine which it is
      Status status;
      switch(selection){
          case "1" -> status = Status.OPEN;
          case "2" -> status = Status.CLOSED_AND_RESOLVED;
          case "3" -> status = Status.CLOSED_AND_UNRESOLVED;
          case "4" -> status = Status.ARCHIVED;
          default -> status = null;
      }
      
      // Same as the method below, but with status
        for (User staff : users.values()) {
            if (staff instanceof Staff) {
                for (Ticket item : ((Staff) staff).getTickets()) {
                    if (Objects.equals(item.getId(), Id)) {
                        item.setStatus(status);
                        System.out.println("Status changed on ticket " + Id + " to the status of: " + item.getStatus());
                    }
                }
            }
        }
      
      this.processTechnicianMenu();  // go back to main menu
    }

    public void changeSeverity(HashMap<String, User> users, String Id) {
        String selection;
        Severity severity;

        this.displaySeverityMenu();
        selection = getInput("Select an option: ");
        // Changes the severity of the chosen ticket based on user input
        switch (selection) {
            case "1" -> severity = Severity.LOW;
            case "2" -> severity = Severity.MEDIUM;
            case "3" -> severity = Severity.HIGH;
            default -> severity = null;
        }

        //Get users selection and load ticket menu for selected ticket  if selection valid
        for (User staff : users.values()) {
            //Only casting if user is staff and not technicians
            if (staff instanceof Staff) {
                // Checks for and selects the ticket that is going to be changed
                for (Ticket item : ((Staff) staff).getTickets()) {
                    if (Objects.equals(item.getId(), Id)) {
                        item.setSeverity(severity);
                        System.out.println("Severity changed on ticket " + Id + " to the severity of: " + item.getSeverity());
                    }
                }
            }
        }
        this.processTechnicianMenu();
    }

    //Logout
    private void logout() {
        this.backend.setCurrentUser(null);
        System.out.println("Program logged-out!");
    }
}
