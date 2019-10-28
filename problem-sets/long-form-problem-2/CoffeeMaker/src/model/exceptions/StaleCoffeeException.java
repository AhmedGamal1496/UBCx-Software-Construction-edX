package model.exceptions;

public class StaleCoffeeException extends Exception {
    private int time;

    public StaleCoffeeException(int time) {
        super(time + " is the time this coffee has been sitting. It is stale now!");
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
