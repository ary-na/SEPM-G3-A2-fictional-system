package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.util.HashMap;
import java.util.Objects;

public class Model {

    private final HashMap<String, User> users;
    private User currentUser;

    public Model() {
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
    }

    // Verify user details and login
    public boolean verifyLogin(String emailAddress, String password) {
        if (users.containsKey(emailAddress) && Objects.equals(users.get(emailAddress).getPassword(), password)) {
            this.setCurrentUser(users.get(emailAddress));
            return true;
        }
        return false;
    }

    // Change password value if forgotten
    public void changePassword(String email, String newPassword) {
        users.get(email).setPassword(newPassword);
    }

    // Create new ticket
    public void createTicket(String description, String severity) {

        Severity s;
        switch (severity) {
            case "LOW" -> s = Severity.LOW;
            case "MEDIUM" -> s = Severity.MEDIUM;
            case "HIGH" -> s = Severity.HIGH;
            default -> s = null;
        }

        var staff = (Staff) this.getCurrentUser();
        staff.addTicket(new Ticket(description, s));
    }

    // Email validation
    public boolean validateEmail(String emailAddress) {
        return users.containsKey(emailAddress);
    }

    // Phone number validation
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[0-9]{10,}$");
    }

    // Password validation
    public boolean validatePassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{20,}$");
    }

    // Severity validation
    public boolean validateSeverity(String severity) {
        return severity.toLowerCase().matches("LOW|MEDIUM|HIGH");
    }
}
