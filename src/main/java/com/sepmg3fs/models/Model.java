package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.TechnicianLevel;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Model {

    private final HashMap<String, User> users;
    private User currentUser;

    public Model() {
        users = new HashMap<>();
        this.initializeTechnicians();
        this.initializeAdmin();
        this.initializeStaff();
    }

    // Get all users
    public HashMap<String, User> getAllUsers() {
        return users;
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

    public void initializeStaff() {

        users.put("aa", new Staff("aa", "aa", "0412345678", "aa"));
        users.put("bb", new Staff("bb", "bb", "0409876543", "bb"));
    }

    public void initializeAdmin() {
        users.put("admin", new Admin("admin", "admin", "0412345678", "admin"));
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
        switch (severity.toLowerCase()) {
            case "low" -> s = Severity.LOW;
            case "medium" -> s = Severity.MEDIUM;
            case "high" -> s = Severity.HIGH;
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
        return severity.toLowerCase().matches("low|medium|high");
    }

    // Date validation
    public boolean validateDate(String date) {
        return date.toLowerCase().matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
    }

    // Get days between Dates
    public long getDaysBetweenDate(String startDate, String endDate) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(startDate, dtf);
        LocalDate date2 = LocalDate.parse(endDate, dtf);
        return ChronoUnit.DAYS.between(date1, date2);
    }

    //Get number of days in report
    public long getReportDays(String startDate, String endDate) {
        long daysBetween = 0;
        try {
            daysBetween = getDaysBetweenDate(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysBetween;
    }

    //Is Date within range?
    public boolean isWithinRange(LocalDateTime test, String startDate, String endDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime start = LocalDateTime.parse(startDate + " 00:01", dtf);
        LocalDateTime end = LocalDateTime.parse(endDate + " 11:59", dtf);
        return !(test.isBefore(start) || test.isAfter(end));
    }

}
