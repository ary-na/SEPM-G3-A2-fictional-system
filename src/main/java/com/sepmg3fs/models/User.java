package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.interfaces.Authorizable;

public abstract class User implements Authorizable {

    private String emailAddress;
    private String fullName;
    private String phoneNumber;
    private String password;

    public User(String emailAddress, String fullName, String phoneNumber, String password){
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
