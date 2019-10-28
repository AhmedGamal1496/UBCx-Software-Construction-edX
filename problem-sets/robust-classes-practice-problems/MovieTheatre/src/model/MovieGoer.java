package model;

import model.exceptions.ShowingFullException;
import model.exceptions.UnderAgeException;

public class MovieGoer {

    private String name;
    private int age;
    private Ticket ticket;
    private TicketKiosk tk;

    public MovieGoer(String name, int age,  TicketKiosk tk) {
        this.name = name;
        this.age = age;
        this.tk = tk;
        ticket = null;
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public int getAge() {
        // TODO: complete the implementation of this method
        return age;
    }
    public TicketKiosk getTicketKiosk() {
        // TODO: complete the implementation of this method
        return tk;
    }
    public Ticket getTicket() {
        // TODO: complete the implementation of this method
        return ticket;
    }

    // MODIFIES: this
    // EFFECTS: a new ticket associated with the given movie is created, and
    //           becomes this MovieGoer's ticket
    //          throws ShowingFullException if the movie is at full capacity
    //          throws UnderAgeException if (age <= m.ageRestriction) is not appropriate
    public void buyTicket(Movie m) throws ShowingFullException, UnderAgeException {
        // TODO: complete the implementation of this method
        if (m.getCurrentSeating() >= m.getMaxSeating()) {
            throw new ShowingFullException();
        }
        else if (this.age <= m.getAgeRestriction()) {
            throw new UnderAgeException();
        }
        else {
           ticket = new Ticket(m);
           tk.addMovie(m);
        }
    }


}
