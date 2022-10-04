package main.java.com.sepmg3fs.models;

public class Staff extends User{

    public Staff(String emailAddress, String fullName, String phoneNumber, String password) {
        super(emailAddress, fullName, phoneNumber, password);
    }

    @Override
    public boolean isLoggedIn(String email, String password) {
        return false;
    }
}
