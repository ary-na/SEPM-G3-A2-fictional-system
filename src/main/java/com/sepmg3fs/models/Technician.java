package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.util.ArrayList;

public class Technician extends User {

    private TechnicianLevel technicianLevel;
    private ArrayList<Ticket> tickets;

    public Technician(String emailAddress, String fullName, String phoneNumber, String password, TechnicianLevel technicianLevel) {
        super(emailAddress, fullName, phoneNumber, password);
        this.technicianLevel = technicianLevel;
    }

    @Override
    public boolean isLoggedIn(String email, String password) {
        return false;
    }
}
