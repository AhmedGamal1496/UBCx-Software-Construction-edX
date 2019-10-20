package model;

import java.util.ArrayList;
import java.util.List;

public class Band {

    private String name;
    private double totalMoney;
    private double currentMoney;
    private List<String> members;
    private int numShowsPlayed;

    public Band(String name) {
        // TODO: complete the implementation of this method
        this.name = name;
        members = new ArrayList<>();
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return name;
    }
    public double getTotalMoney() {
        // TODO: complete the implementation of this method
        return totalMoney;
    }
    public double getCurrentMoney() {
        // TODO: complete the implementation of this method
        return currentMoney;
    }
    public List<String> getMembers() {
        // TODO: complete the implementation of this method
        return members;
    }
    public int getNumShowsPlayed() {
        // TODO: complete the implementation of this method
        return numShowsPlayed;
    }

    // MODIFIES: this
    // EFFECTS: adds a member with the given name to the band
    public void addMember(String name) {
        // TODO: complete the implementation of this method
        members.add(name);
    }

    // MODIFIES: this
    // EFFECTS: given an amount the band will be played for the show, update
    //          the current money and total money by the amount, and add one to
    //          the number of shows played.
    public void playGig(double amt) {
        // TODO: complete the implementation of this method
        totalMoney += amt;
        currentMoney += amt;

        numShowsPlayed++;
    }

    // MODIFIES: this
    // EFFECTS: pays the given amount to each band member, the total paid
    //          is subtracted from the current money. If there is not enough
    //          money, nothing happens
    public void payMembers(double amt) {
        // TODO: complete the implementation of this method
        if (amt*members.size() < currentMoney) {
            currentMoney -= amt*members.size();
        }
    }

    // REQUIRES: numShowsPlayed > 0
    // MODIFIES: nothing
    // EFFECTS: computes the average amount the band is payed per show
    public double averagePerShow() {
        // TODO: complete the implementation of this method
        return totalMoney/numShowsPlayed;
    }


}
