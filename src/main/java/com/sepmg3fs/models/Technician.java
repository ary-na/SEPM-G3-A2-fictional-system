package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.util.ArrayList;

public class Technician extends User {

    private TechnicianLevel technicianLevel;
    private ArrayList<Ticket> tickets;

    @Override
    public boolean isLoggedIn(String email, String password) {
        return false;
    }
}
