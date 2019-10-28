package model;

import java.util.HashMap;

public class PersonalDataStorage {
    private HashMap<Integer, String> dataStorage = new HashMap<>();
    private int customerIdCounter;

    public static final int FIRST_CUSTOMER_NUMBER = 100;

    public PersonalDataStorage() {
        this.customerIdCounter = FIRST_CUSTOMER_NUMBER;
    }

    // EFFECTS: Create a new customer with the given address and name
    public Customer signUpNewCustomer(String address, String name) {
        return new Customer(name, address, customerIdCounter++);
    }

    // MODIFIES: this
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(Customer c, String data) {
        dataStorage.put(c.getUniqueId(), data);
    }

    // Returns the given customer's data from the cloud
    public String getData(Customer c) {
        return dataStorage.get(c.getUniqueId());
    }

    // MODIFIES: this
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(Customer c) {
        return dataStorage.remove(c.getUniqueId());
    }
}

