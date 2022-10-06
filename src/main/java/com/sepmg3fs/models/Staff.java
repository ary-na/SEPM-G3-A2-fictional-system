package main.java.com.sepmg3fs.models;

import java.util.ArrayList;

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
}
