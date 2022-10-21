package test.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.*;
import main.java.com.sepmg3fs.models.types.Severity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignTicketTechnicianTest {

    private Ticket ticket1;
    private Ticket ticket2;
    private Ticket ticket3;
    private Ticket ticket4;
    private Ticket ticket5;
    private Ticket ticket6;
    private Ticket ticket7;
    private Ticket ticket8;
    private AssignTicketTechnician assignTicketTechnician;
    private Model model;

    @Before
    public void setUp() {
        ticket1 = new Ticket("3.1", Severity.HIGH);
        ticket2 = new Ticket("3.2", Severity.LOW);
        ticket3 = new Ticket("3.3", Severity.MEDIUM);
        ticket4 = new Ticket("3.4", Severity.HIGH);
        ticket5 = new Ticket("3.5", Severity.HIGH);
        ticket6 = new Ticket("3.6", Severity.HIGH);
        ticket7 = new Ticket("3.7", Severity.HIGH);
        ticket8 = new Ticket("3.8", Severity.HIGH);
        assignTicketTechnician = new AssignTicketTechnician();
        model = new Model();
    }

    @After
    public void tearDown() {
        ticket1 = null;
        ticket2 = null;
        ticket3 = null;
        ticket4 = null;
        ticket5 = null;
        ticket6 = null;
        ticket7 = null;
        ticket8 = null;
        assignTicketTechnician = null;
        model = null;
    }

    @Test
    public void testAssignTicketTechnicianReturnedObject() {
        Technician object = ticket1.getAssignedTo().get(0);
        assertSame(object, ticket1.getAssignedTo().get(0));
    }

    @Test
    public void testAssignTicketTechnicianObject() {
        assertNotNull(assignTicketTechnician);
    }

    @Test
    public void testAssignTicketTechnician() {
        assertEquals(model.getAllUsers().get("harry.styles@cinco.com").getEmailAddress(), ticket8.getAssignedTo().get(0).getEmailAddress());
    }
}
