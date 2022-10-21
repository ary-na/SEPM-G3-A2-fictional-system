package main.java.com.sepmg3fs.models;


import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static main.java.com.sepmg3fs.utilities.UtilityMethods.createID;

public class Ticket {

    private String description;
    private final String Id;
    private Severity severity;
    private Status status;
    private LocalDateTime submissionTime;
    private final ArrayList<Technician> assignedTo;
    private Duration duration;
    private final AssignTicketTechnician assignTicketTechnician;

    public Ticket(String description, Severity severity) {
        this.Id = createID();
        this.description = description;
        this.severity = severity;
        this.status = Status.OPEN;
        this.submissionTime = LocalDateTime.now();
        this.assignedTo = new ArrayList<>();
        this.assignTicketTechnician = new AssignTicketTechnician();
        this.setAssignedTo();
    }

    // Getters and setters
    public String getId() {
        return Id;
    }

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
        if (!this.status.equals(Status.OPEN)) {
            this.duration = Duration.between(submissionTime, LocalDateTime.now());
        }
    }
    
    public void checkSetArchive(Status status) {
    	int daySec = 86400;
    	if (this.duration.toSeconds() < daySec) {
    		this.setStatus(status);
    	} else if (this.duration.toSeconds() >= daySec) {
    		this.setStatus(Status.ARCHIVED);
    	}
    } 

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void updateAssignedTo(Technician Technician) {
        this.assignedTo.add(Technician);
    }

    public ArrayList<Technician> getAssignedTo() {
        return assignedTo;
    }

    public Duration getDuration() {
        return duration;
    }


    public void setAssignedTo() {
        this.assignedTo.add(assignTicketTechnician.AssignTo());
    }

}
