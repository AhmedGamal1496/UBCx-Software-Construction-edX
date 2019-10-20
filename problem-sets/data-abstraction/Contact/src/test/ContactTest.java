package test;

import model.Contact;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static model.ContactType.*;
import static org.junit.Assert.assertEquals;

public class ContactTest {
    private Contact contact1;
    private Contact contact2;

    @Before
    public void SetUp() {
        contact1 = new Contact("Jimbo");
        contact1.setContactType(FAMILY);
        contact1.setNumber("01091798922");
        contact2 = new Contact("Elrasad");
        contact2.setNumber("01064879231");
        contact2.setContactType(FRIEND);
    }

    @Test
    public void testGetters() {
        assertEquals(contact1.getName(), "Jimbo");
        assertEquals(contact1.getNumber(), "01091798922");
        assertEquals(contact2.getNumber(), "01064879231");
        assertEquals(contact2.getContactType(), FRIEND);
        assertEquals(contact1.getCallLogs(), Collections.emptyList());
    }

    @Test
    public void testcallLog() {
        assertEquals(contact1.callLog().size(), 0);
        contact1.AddToLog("12/01/1996");
        assertEquals(contact1.callLog().size(), 1);
        contact2.AddToLog("04/05/1996");
        contact2.AddToLog("08/31/2001");
        assertEquals(contact2.callLog().size(), 2);
    }

    @Test
    public void testautomateResponse() {
        assertEquals(contact1.automateRespone(), "See you at home");
        assertEquals(contact2.automateRespone(), "Meet you at the cafe");
    }
}
