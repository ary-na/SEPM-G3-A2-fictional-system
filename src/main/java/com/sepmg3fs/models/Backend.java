package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.User;
import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.util.HashMap;

public class Backend {

    private HashMap<String, User> users;
    private User currentUser;

    public Backend() {
        users = new HashMap<>();
        this.initializeTechnicians();
    }

    // Get logged in user
    public User getCurrentUser() {
        return currentUser;
    }

    // Set logged in user
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // Initialize account for technicians
    public void initializeTechnicians() {

        // Level 1 technicians
        users.put("harry.styles@cinco.com", new Technician("harry.styles@cinco.com", "Harry Styles", "0412345678", "Harry12345678", TechnicianLevel.LEVEL_ONE));
        users.put("niall.horan@cinco.com", new Technician("niall.horan@cinco.com", "Niall Horan", "0409876543", "Niall09876543", TechnicianLevel.LEVEL_ONE));
        users.put("liam.payne@cinco.com", new Technician("liam.payne@cinco.com", "Liam Payne", "0409871234", "Liam09871234", TechnicianLevel.LEVEL_ONE));

        // Level 2 technicians
        users.put("louis.tomlinson@cinco.com", new Technician("louis.tomlinson@cinco.com", "Louis Tomlinson", "0444554455", "Louis44554455", TechnicianLevel.LEVEL_TWO));
        users.put("zayn.malik@cinco.com", new Technician("zayn.malik@cinco.com", "Zayn Malik", "0411221122", "Zayn11221122", TechnicianLevel.LEVEL_TWO));
    }

    // Create new user account
    public void createAccount(String email, String fullName, String phoneNumber, String password) {
        users.put(email, new Staff(email, fullName, phoneNumber, password));
        this.setCurrentUser(users.get(email));
    }

    public boolean validateEmail(String email) {
        return users.containsKey(email);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("^[0-9]{10,}$");
    }

    public boolean validatePassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{20,}$");
    }
}
