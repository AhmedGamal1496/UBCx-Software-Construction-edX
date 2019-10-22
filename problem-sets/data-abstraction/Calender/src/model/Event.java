package model;

public class Event extends Entry {
    private Remainder remainder;

    public Event(Time time, Date date, String label) {
        super(time, date, label);
    }

    //getters
    public Remainder getRemainder() { return remainder; }

    //setters
    public void setRemainder(Remainder r) {
        this.remainder = r;
    }
}
