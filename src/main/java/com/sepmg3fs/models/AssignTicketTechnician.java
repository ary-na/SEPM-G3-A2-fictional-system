package main.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.interfaces.Assignable;

import java.util.ArrayList;
import java.util.Random;

public class AssignTicketTechnician implements Assignable {

    private final Model model;
    private Technician technician;
    private int ticketNo;

    public AssignTicketTechnician() {
        model = new Model();
        ticketNo = 0;
    }

    // Assign ticket to a technician
    @Override
    public Technician AssignTo() {
        var users = model.getAllUsers();
        ticketNo = getLeastNumberOfTickets();
        if (isTicketNumberEqualForAllTechnicians()) {
            ArrayList<Object> usersArray = new ArrayList<>();
            for (String user : users.keySet()) {
                if (users.get(user) instanceof Technician) {
                    usersArray.add(user);
                }
            }
            var technician = usersArray.get(new Random().nextInt(usersArray.size()));
            this.technician = (Technician) users.get(technician);

        } else {
            for (User user : users.values()) {
                if (user instanceof Technician && ticketNo == ((Technician) user).getTickets().size()) {
                    technician = (Technician) user;
                    break;
                }
            }
        }
        return technician;
    }

    // Return the initial value of assigned tickets to a technician
    private int setInitialTicketNumberValue() {
        var users = model.getAllUsers();
        for (User user : users.values()) {
            if (user instanceof Technician && ((Technician) user).getTickets().size() > 0)
                ticketNo = ((Technician) user).getTickets().size();
            break;
        }
        return ticketNo;
    }

    // Return least number of tickets assigned to a technician
    private int getLeastNumberOfTickets() {
        ticketNo = setInitialTicketNumberValue();
        var users = model.getAllUsers();
        for (User user : users.values()) {
            if (user instanceof Technician && ticketNo >= ((Technician) user).getTickets().size()) {
                ticketNo = ((Technician) user).getTickets().size();
            }
        }
        return ticketNo;
    }

    // Return if all technicians have equal number of tickets
    private boolean isTicketNumberEqualForAllTechnicians() {
        ticketNo = this.setInitialTicketNumberValue();
        var isEqual = false;
        var users = model.getAllUsers();
        for (User user : users.values()) {
            isEqual = user instanceof Technician && ticketNo == ((Technician) user).getTickets().size();
            if (!isEqual)
                return false;
        }
        return isEqual;
    }
}
