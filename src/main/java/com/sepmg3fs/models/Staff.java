package main.java.com.sepmg3fs.models;

public class Staff extends User{

    @Override
    public boolean isLoggedIn(String email, String password) {
        return false;
    }
}
