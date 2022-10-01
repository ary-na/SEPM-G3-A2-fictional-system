package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.interfaces.Authorizable;

public abstract class User implements Authorizable {

    private String emailAddress;
    private String fullName;
    private int phoneNumber;
    private String password;

}
