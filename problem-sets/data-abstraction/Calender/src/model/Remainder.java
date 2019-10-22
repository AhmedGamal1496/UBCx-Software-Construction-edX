package model;

public class Remainder extends Entry {
    private String note;

    public Remainder(Time time, Date date, String label) {
        super(time, date, label);
    }

    //getters
    public String getNote() { return note; }

    //setters
    public void setNote(String note) {
        this.note = note;
    }
}
