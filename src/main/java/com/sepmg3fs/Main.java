package main.java.com.sepmg3fs;

public class Main {
    public static void main(String[] args) {
        var backend = new FictionalSystemBackend();
        var app = new FictionalSystemFrontEnd(backend);
        app.run();
    }
}