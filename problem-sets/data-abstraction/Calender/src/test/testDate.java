package test;

import model.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testDate {
    private Date date1;

    @Before
    public void SetUp() {
        date1 = new Date(23, 05, 1999);
    }

    @Test
    public void testGetters() {
        assertEquals(date1.getDay(), 23);
        assertEquals(date1.getMonth(), 05);
        assertEquals(date1.getYear(), 1999);
        assertEquals(date1.getShortFormat(), "5/23/1999");
        assertEquals(date1.getLongFormat(), "May 23, 1999");
    }
}
