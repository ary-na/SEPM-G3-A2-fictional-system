package main.java.com.sepmg3fs;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import javax.print.attribute.standard.Severity;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Technician;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.User;
import main.java.com.sepmg3fs.models.types.Status;

public class FrontEndAdmin {

    private ArrayList<Ticket> ticketsInPeriod;
    private final Model backend;
    private final ArrayList<Ticket> ticketsInDateRange;

    public FrontEndAdmin(Model backend) {
        this.backend = backend;
        this.ticketsInDateRange = new ArrayList<Ticket>();
    }

    public void run() {

        this.ProcessAdminMenu();
    }

    //Display staff menu
    private void displayAdminMenu() {
        String menu = """

                Welcome to Cinco System

                [1] Produce Report
                [2] Logout
                """;

        System.out.println(menu);
    }

    private void ProcessAdminMenu() {
        String selection;
        var exit = false;

        do {
            this.displayAdminMenu();
            selection = getInput("Select an option: ");

            switch (selection) {
                case "1" -> displayReport();
                case "2" -> {
                    exit = true;
                    logout();
                }
                default -> System.err.println("\nSelect a valid menu option\n");
            }

        } while (!exit);
    }

    //Logout
    private void logout() {
        this.backend.setCurrentUser(null);
        System.out.println("Program logged-out!");
    }

    //Get date range and Display Report
    private void displayReport() {

        String startDate;
        String endDate;

        // Validate start date
        startDate = getInput("Please enter start date of your report (dd/mm/yyyy): ");
        while (!this.backend.validateDate(startDate)) {
            System.out.println("\n** error ** Invalid start date, please type in the following format: dd/mm/yyyy (include \"/\" between days months and years)\n");
            startDate = getInput("Please enter start date of your report (dd/mm/yyyy): ");
        }
        // Validate end date
        endDate = getInput("Please enter end date of your report (dd/mm/yyyy): ");
        while (!this.backend.validateDate(endDate)) {
            System.out.println("\n** error ** Invalid start date, please type in the following format: dd/mm /yyyy (include \"/\" between days months and years)\n");
            endDate = getInput("Please enter end date of your report (dd/mm/yyyy): ");
        }
        //Get Report Duration
        long daysBetween = 0;
        try {
            daysBetween = this.backend.getDaysBetweenDate(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Display Report
        System.out.println("Report of : " + daysBetween + " days\n");
        displayReportHeader();
        getTickets(startDate, endDate);
        displayTicketCount();


    }

    //Get tickets in date range and display tickets
    private void getTickets(String startDate, String endDate) {
        String allAssigned = null;

        this.ticketsInPeriod = new ArrayList<>();
        //Get all tickets from Staff within range
        for (User staff : this.backend.getAllUsers().values()) {
            if (staff instanceof Staff) {
                for (Ticket item : ((Staff) staff).getTickets()) {
                    if (this.backend.isWithinRange(item.getSubmissionTime(), startDate, endDate)) {
                        ticketsInPeriod.add(item);
                        //Display Tickets
                        //Add ticket duration if closed
                        if (!item.getStatus().equals(Status.OPEN)) {
                            System.out.println("[" + item.getId() + "] Submitted By: " + staff.getFullName() + " Description: "
                                    + item.getDescription() + " Severity: " + item.getSeverity() + " Status: " + item.getStatus() + " Duration Ticket was open: " + item.getDuration().getSeconds() + "seconds");
                        } else //display without ticket duration
                            for (Technician assigned : item.getAssignedTo()) {
                                allAssigned = allAssigned + ", " + assigned.getFullName();
                            }
                        System.out.println("[" + item.getId() + "] Submitted By: " + staff.getFullName() + " Description: "
                                + item.getDescription() + " Severity: " + item.getSeverity() + " Status: " + item.getStatus() + " Technicians who have been assigned ticket " + allAssigned);
                    }
                }
            }
        }

    }

    // get number of total tickets
    private void displayTicketCount() {
        int totalTickets = 0;
        int openTickets = 0;
        int closedTickets = 0;

        //total tickets
        totalTickets = ticketsInPeriod.size();
        //open and closed tickets
        for (Ticket item : ticketsInPeriod) {
            if (item.getStatus().equals(Status.OPEN)) {
                openTickets += 1;
            } else closedTickets += 1;
        }

        String ticketCount = "Total tickets submitted: " + totalTickets + "\nTotal open tickets: " + openTickets + "\nTotal closed tickets " + closedTickets;
        System.out.println(ticketCount);
    }

    //Display report header
    private void displayReportHeader() {
        String menu = """

                Report

                 		                
                """;

        System.out.println(menu);
    }
}
