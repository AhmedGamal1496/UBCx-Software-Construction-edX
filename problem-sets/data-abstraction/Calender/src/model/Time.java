package model;

public class Time {
    private int hours;
    private int minutes;

    //REQUIRES: 0 <= hours <= 24, 0 <= minutes <= 60
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    //getters
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public String getTimeFormat() {
        return hours + ":" + minutes;
    }
}
