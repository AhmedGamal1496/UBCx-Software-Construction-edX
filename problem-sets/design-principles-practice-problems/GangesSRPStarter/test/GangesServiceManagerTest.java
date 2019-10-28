package test;

import model.BookOrder;
import model.Customer;
import model.BookPurchases;
import model.PersonalDataStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the model.GangesServiceManager. These tests should pass with the starter code, and after successful refactoring.
 */

public class GangesServiceManagerTest {

    private BookPurchases bookPurchase;
    private Customer customer;
    private PersonalDataStorage dataStorage;
    private static final String NAME = "Crystal Shanda Lear";
    private static final String ADDR = "123 Waltz St";
    private static final int ID = 12345;

    @BeforeEach
    public void setup() {
        bookPurchase = new BookPurchases();
        customer = new Customer(NAME, ADDR, ID);
        dataStorage = new PersonalDataStorage();
    }

    @Test
    public void testNewCustomer() {
        Customer c = dataStorage.signUpNewCustomer(ADDR, NAME);
        assertEquals(c.getName(), NAME);
        assertEquals(c.getAddress(), ADDR);
        assertTrue(c.getUniqueId() > 0);
    }

    @Test
    public void listAvaliableBooks() {
        bookPurchase.listAvailableBooks();
    }

    @Test
    public void orderBook() {
        BookOrder order = bookPurchase.orderBook(customer, 1);
        assertEquals(order.getCustomer(), customer);
        assertTrue(order.getOrderNumber() > 0);
    }

    @Test
    public void cancelOrder() {
        BookOrder order = bookPurchase.orderBook(customer, 1);
        assertTrue(bookPurchase.cancelBookOrder(order.getOrderNumber()));
        int fakeOrderNum = 5;
        assertFalse(bookPurchase.cancelBookOrder(fakeOrderNum));
    }

    @Test
    public void putAndGetNewData() {
        assertNull(dataStorage.getData(customer));
        String dataString = "I am the very model of a modern major general";
        dataStorage.putData(customer, dataString);
        assertEquals(dataStorage.getData(customer), dataString);
    }

    @Test
    public void putDataOverwrite() {
        assertNull(dataStorage.getData(customer));
        String dataString = "I've information vegetable animal and mineral";
        dataStorage.putData(customer, dataString);
        assertEquals(dataStorage.getData(customer), dataString);

        String newDataString = "I know the kings of England and I quote the fights historical";
        dataStorage.putData(customer, newDataString);
        assertEquals(dataStorage.getData(customer), newDataString);
    }

    @Test
    public void deleteData() {
        String dataString = "From Marathon to Waterloo in order categorical";
        dataStorage.putData(customer, dataString);
        assertEquals(dataStorage.getData(customer), dataString);

        dataStorage.deleteData(customer);
        assertNull(dataStorage.getData(customer));
    }
}
