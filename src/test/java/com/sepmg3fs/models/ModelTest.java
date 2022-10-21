package test.java.com.sepmg3fs.models;

import main.java.com.sepmg3fs.models.Model;
import main.java.com.sepmg3fs.models.Staff;
import main.java.com.sepmg3fs.models.Ticket;
import main.java.com.sepmg3fs.models.types.Severity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.text.ParseException;

import static org.junit.Assert.*;

public class ModelTest {

    private Model model;
    private Staff user1;
    private Ticket ticket;

    @Before
    public void setUp() {
        model = new Model();
        user1 = new Staff("aa@aa.com", "Varshan Shankar", "0410111222", "Vv01234567890123456789");
        ticket = new Ticket("ticket", Severity.HIGH);
        model.createAccount(user1.getEmailAddress(), user1.getFullName(), user1.getPhoneNumber(), user1.getPassword());
        model.setCurrentUser(user1);
        model.createTicket("test", "high");
    }

    @After
    public void tearDown() {
        model = null;
        user1 = null;
        ticket = null;
    }

    @Test
    public void testVerifyLogin() {
        assertTrue(model.verifyLogin(user1.getEmailAddress(), user1.getPassword()));
    }

    @Test
    public void testChangePassword() {
        model.changePassword(user1.getEmailAddress(), "Aa12345678901234567890");
        model.getCurrentUser().setPassword("Aa12345678901234567890");
        assertEquals("Aa12345678901234567890", model.getCurrentUser().getPassword());
    }

    @Test
    public void testCreateTicket() {
        assertNotNull(user1.getTickets().get(0));
    }

    @Test
    public void testValidateEmail() {
        assertTrue(model.validateEmail(user1.getEmailAddress()));
    }

    @Test
    public void testValidatePhoneNumber() {
        assertTrue(model.validatePhoneNumber(user1.getPhoneNumber()));
    }

    @Test
    public void testValidatePassword() {
        assertTrue(model.validatePassword(user1.getPassword()));
    }

    @Test
    public void testValidateSeverity() {
        assertTrue(model.validateSeverity("low"));
    }

    @Test
    public void testValidateDate() {
        assertTrue(model.validateDate("09-10-2022"));
    }

    @Test
    public void testGetDaysBetweenDate() throws ParseException {
        assertEquals(1, model.getDaysBetweenDate("20/10/2022", "21/10/2022"));
    }

    @Test
    public void testReportDays() {
        assertEquals(2, model.getReportDays("19/10/2022", "21/10/2022"));
    }

    @Test
    public void testIsWithinRange() {
        assertTrue(model.isWithinRange(ticket.getSubmissionTime(), "10/11/2000", "10/12/2024"));
    }
}