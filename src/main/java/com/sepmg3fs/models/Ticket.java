package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.interfaces.Assignable;

public class Ticket implements Assignable {
	 private String description;
	 private String severity;
	 
	    

	    public Ticket(String description, String severity) {
	        this.description = description;
	        this.severity = severity;
	        
	     
	    }
	    // Getters and setters
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getSeverity() {
	        return severity;
	    }

	    public void setSeverity(String severity) {
	        this.severity = severity;
	    }

	   
    @Override
    public void AssignTo(Technician technician) {

    }
}
