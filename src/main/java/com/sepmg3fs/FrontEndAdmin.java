package main.java.com.sepmg3fs;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.getInput;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.User;

public class FrontEndAdmin {
	

	private final Model backend;
	//private final ArrayList<Ticket> ticketsInDateRange;

	public FrontEndAdmin(Model backend) {
	   this.backend = backend;
	 //  this.ticketsInDateRange = new ArrayList<Ticket>();
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
    
    //Display Report
    private void displayReport() {
    	
        String startDate;
        String endDate;
        // Validate start date
        startDate = getInput("Please enter start date of your report (dd/mm/yyyy): ");
        while (!this.backend.validateDate(startDate)) {
            System.out.println("\n** error ** Invalid start date, please type in the following format: dd/mm/yyyy (include / between days months and years)\n");
            startDate = getInput("Please enter start date of your report (dd/mm/yyyy): ");
        }
        // Validate end date
        endDate = getInput("Please enter end date of your report (dd/mm/yyyy): ");
        while (!this.backend.validateDate(endDate)) {
            System.out.println("\n** error ** Invalid start date, please type in the following format: dd/mm /yyyy (include / between days months and years)\n");
            endDate = getInput("Please enter end date of your report (dd/mm/yyyy): ");
        }
        
       long daysBetween = 0;
	try {
		daysBetween = this.backend.getDaysBetweenDate(startDate, endDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       System.out.println("Report of : " + daysBetween + " days")
        ;
    }
    //Get tickets in date range
    private ArrayList<Ticket> tickets(String startDate, String endDate){
    	
        ArrayList<Ticket> tickets = new ArrayList<>();
    	//Get all tickets from Staff
        for (User staff : this.backend.getAllUsers().values()) {
            if (staff instanceof Staff) {
                for (Ticket item : ((Staff) staff).getTickets()) {
                    if (this.backend.isWithinRange(item.getSubmissionTime(), startDate, endDate)) {
                        tickets.add(item);
                        System.out.println("Ticket " + item.getId() + " added.");
                    }
                }
            }
        }
		return tickets;

    }
    
//    //Get number of days in report
//    private long getReportDays(String startDate, String endDate) {
//    	long daysBetween = 0;
//		try {
//			daysBetween = this.backend.getDaysBetweenDate(startDate, endDate);
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//        return  daysBetween;
        
    	
    
}
