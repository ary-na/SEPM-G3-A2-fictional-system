package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Model;

public class Main {
    public static void main(String[] args) {
        var backend = new Model();
        var app = new FrontEndMain(backend);
        app.run();
    }
}