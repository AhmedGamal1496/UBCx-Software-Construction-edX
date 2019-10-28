package model;

import java.util.ArrayList;
import java.util.List;

public class Calender {
    private Date currentDate;
    private String email;
    private List<Entry> entries;

    public Calender(Date date) {
        this.currentDate = date;
        entries = new ArrayList<>();
    }

    //getters
    public Date getCurrentDate() { return currentDate; }
    public String getEmail() { return email; }
    public List<Entry> getEntries() { return entries; }

    //setters
    public void setEmail(String e) {
        this.email = e;
    }


    //REQUIRES: e != null, date of e is in the future
    //MODIFIES: this
    //EFFECTS: add e to the list of entries
    public void addEntry(Entry e) {
        entries.add(e);
    }

    //REQUIRES: e that does exist in entry
    //MODIFIES: this
    //EFFECTS: remove e from the list of entries
    public void removeEntry(Entry e) {
        entries.remove(e);
    }
}
