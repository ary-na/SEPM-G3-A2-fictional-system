package test.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.types.Severity;
import main.java.com.sepmg3fs.models.types.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void setUp() {
        ticket = new Ticket("Test", Severity.LOW);
    }

    @After
    public void tearDown() {
        ticket = null;
    }

    @Test
    public void testTicketAutoAssignStatus() {
        assertEquals(Status.OPEN, ticket.getStatus());
    }

    @Test
    public void testChangeTicketSeverity(){
        ticket.setSeverity(Severity.HIGH);
        assertEquals(Severity.HIGH, ticket.getSeverity());
    }

    @Test
    public void testChangeTicketStatus(){
        ticket.setStatus(Status.CLOSED_AND_RESOLVED);
        assertEquals(Status.CLOSED_AND_RESOLVED, ticket.getStatus());
    }

}
