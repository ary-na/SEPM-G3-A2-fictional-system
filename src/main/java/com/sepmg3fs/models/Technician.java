package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.util.ArrayList;

public class Technician extends User {

    private TechnicianLevel technicianLevel;
    private final ArrayList<Ticket> tickets;

    public Technician(String emailAddress, String fullName, String phoneNumber, String password, TechnicianLevel technicianLevel) {
        super(emailAddress, fullName, phoneNumber, password);
        this.technicianLevel = technicianLevel;
        this.tickets = new ArrayList<>();
    }

    // Getters and setters
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    

    public void setTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public TechnicianLevel getTechnicianLevel() {
        return technicianLevel;
    }

    public void setTechnicianLevel(TechnicianLevel technicianLevel) {
        this.technicianLevel = technicianLevel;
    }
    
}
