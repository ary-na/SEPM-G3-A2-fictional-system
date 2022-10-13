package main.java.com.sepmg3fs.models;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.sepmg3fs.models.types.Status;

public class Staff extends User {

    private final ArrayList<Ticket> tickets;

    public Staff(String emailAddress, String fullName, String phoneNumber, String password) {
        super(emailAddress, fullName, phoneNumber, password);
        this.tickets = new ArrayList<>();
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void displayTickets() {
        System.out.println("***************************Your Open Tickets**************************************");
        for (Ticket item : tickets) {
            if (item.getStatus().equals(Status.OPEN)) {
                System.out.println("Description: " + item.getDescription() + " Severity: " + item.getSeverity() + " Status: " + item.getStatus());
                System.out.println("---------------------------------------------------------------------------------");
            }
        }
    }

    public int displayAllTickets(int counter) {
        for (Ticket ticket : tickets) {
            System.out.println("[" + counter +  "] Staff Full Name: " + this.getFullName() + " Description: " + ticket.getDescription() + " Severity: " + ticket.getSeverity() + " Status: " + ticket.getStatus());
            counter++;
        }
        return counter;
    }

    public Ticket getTicketByIndex(int index) {
        return tickets.get(index);
    }
}
