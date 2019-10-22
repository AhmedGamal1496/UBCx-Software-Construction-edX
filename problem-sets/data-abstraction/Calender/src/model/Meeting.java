package model;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event {
    private List<String> attendeesEmail;

    public Meeting(Time time, Date date, String label) {
        super(time, date, label);
        attendeesEmail = new ArrayList<>();
    }

    //getters
    public List<String> getAttendeesEmail() {
        return attendeesEmail;
    }

    // !!!
    //EFFECTS: print all email addresses invited after the prefix "Inviting: ..."
    public String sendInvitation() {
        return "";
    }

    //REQUIRES: email address that does not exist in the list
    //MODIFIES: this
    //EFFECTS: add an email address to the list of attendees
    public void addAttendee(String email) {
        attendeesEmail.add(email);
    }

    //REQUIRES: email address that exist in the list
    //MODIFIES: this
    //EFFECTS: remove an email address from the list of attendees
    public void removeAttendee(String email) {
        attendeesEmail.remove(email);
    }
}
