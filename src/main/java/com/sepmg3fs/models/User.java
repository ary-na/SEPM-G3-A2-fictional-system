package main.java.com.sepmg3fs.models;

public abstract class User {

    private String emailAddress;
    private String fullName;
    private String phoneNumber;
    private String password;

    public User(String emailAddress, String fullName, String phoneNumber, String password) {
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Getters and setters
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
