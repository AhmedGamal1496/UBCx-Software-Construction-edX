package model;

import java.util.ArrayList;
import java.util.List;

import static model.ContactType.*;

public class Contact {
    private String name;
    private String number;
    private ContactType type;
    private List<String> callLogs;

    //Constructor
    public Contact(String name) {
        this.name = name;
        callLogs = new ArrayList<>();
    }

    //getters
    public String getName() { return name; }
    public String getNumber() { return number; }
    public ContactType getContactType() { return type; }
    public List<String> getCallLogs() { return callLogs; }

    //setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setContactType(ContactType type) {
        this.type = type;
    }

    //EFFECTS: return the call log list
    public List<String> callLog() {
        return callLogs;
    }

    //REQUIRES: date is a string in the format MM/DD/YY
    //MODIFIES: this
    //EFFECTS: add the given date to the call log
    public void AddToLog(String date) {
        callLogs.add(date);
    }

    //EFFECTS: return a response in string format based on the type of the contact
    public String automateRespone() {
        if (this.type == WORK) {
            return "I'll get to you at work";
        }
        else if (this.type == FAMILY) {
            return "See you at home";
        }
        else {
            return "Meet you at the cafe";
        }
    }
}
