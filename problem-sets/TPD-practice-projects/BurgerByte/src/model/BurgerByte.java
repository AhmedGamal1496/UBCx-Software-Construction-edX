package model;

import com.sun.xml.internal.ws.api.pipe.SyncStartForAsyncFeature;

import java.util.LinkedList;
import java.util.List;

public class BurgerByte {

    private String location;
    private Manager manager;
    private List<Employee> staff;
    private boolean isOpen;

    public BurgerByte(String locn, Manager manager) {
        location = locn;
        this.manager = manager;
        staff = new LinkedList<>();
    }

    // getters
    public String getLocation() { return location; }
    public Manager getManager() { return manager; }
    public List<Employee> getStaff() { return staff; }
    public boolean isOpen() { return isOpen; }

    // EFFECTS: "opens" this restaurant, i.e. set isOpen to true
    public void openRestaurant() {
        isOpen = true;
    }

    // EFFECTS: sets the isOpen field to false, and sends all employees home (off work)
    public void closeRestaurant() {
        isOpen = false;
        for (Employee c : staff) {
            c.leaveWork();
        }
    }

    // REQUIRES: c must not be in this cashiers or this BurgerByte's Manager's cashiers
    // MODIFIES: this
    // EFFECTS: adds the given cashier to this cashiers
    public void addStaff(Employee c) {
        staff.add(c);
        manager.getTeam().add(c);
    }

    // REQUIRES: c must be in this cashiers and this BurgerByte's Manager's cashiers
    // MODIFIES: this
    // EFFECTS: removes the given cashier from this cashiers
    public void removeStaff(Employee c) {
        staff.remove(c);
        manager.getTeam().remove(c);
    }

    // EFFECTS: computes wages for all employees, prints them out in this format
    //          Name: ______, Salary: _______ for each employee
    public void computeStaffWages() {
        for (Employee c : staff) {
            System.out.println("Name: " + c.getName() +", Salary: " + c.computeWage());
        }
    }
}