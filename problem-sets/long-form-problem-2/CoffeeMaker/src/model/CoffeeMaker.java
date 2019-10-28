package model;

import model.exceptions.*;

import java.beans.Beans;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {
    private int cupsRemaining;
    private int timeSinceLastBrew;

    public CoffeeMaker(){
        // TODO: complete the implementation of this method
        cupsRemaining = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        // TODO: complete the implementation of this method
        return timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        // TODO: complete the implementation of this method
        return cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        // TODO: complete the implementation of this method
        if (this.getCupsRemaining() > 0){
            return true;
        }
        return false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        // TODO: complete the implementation of this method
        timeSinceLastBrew = time;
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //          throws BeansAmountException if beans are not between 2.40 and 2.60
    //          throws WaterException if water <= 14.75
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        // TODO: complete the implementation of this method
        if (beans < 2.4) {
            throw new NotEnoughBeansException(beans);
        }
        else if (beans > 2.6) {
            throw new TooManyBeansException(beans);
        }
        else if (water <= 14.75) {
            throw new WaterException(water);
        }
        else {
            cupsRemaining = 20;
            timeSinceLastBrew = 0;
        }
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException if cups remaining = 0
    //          throws StaleCoffeeException if time since last brew >= 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        // TODO: complete the implementation of this method
        if (this.getCupsRemaining() == 0) {
            throw new NoCupsRemainingException();
        }
        else if (this.getTimeSinceLastBrew() >= 60) {
            throw new StaleCoffeeException(this.getTimeSinceLastBrew());
        }
        cupsRemaining--;
    }


}
