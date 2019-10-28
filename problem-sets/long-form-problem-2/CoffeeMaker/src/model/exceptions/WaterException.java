package model.exceptions;

public class WaterException extends Exception {
    private double amount;

    public WaterException(double amount) {
        super(amount + " is not enough to supply the machine!");
    }

    public double getAmount() {
        return amount;
    }
}
