package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.interfaces.Assignable;
import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;

public class Ticket implements Assignable {

    private String description;
    private Severity severity;
    private Status status;

    public Ticket(String description, Severity severity) {
        this.description = description;
        this.severity = severity;
        this.status = Status.OPEN;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void AssignTo(Technician technician) {

    }
}
