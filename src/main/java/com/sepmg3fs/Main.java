package main.java.com.sepmg3fs;

import main.java.com.sepmg3fs.models.Backend;

public class Main {
    public static void main(String[] args) {
        var backend = new Backend();
        var app = new FrontEndMain(backend);
        app.run();
    }
}