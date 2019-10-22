package model.veggies;

import model.VegType;
import model.Vegetable;

public class Carrot extends Vegetable {

    public Carrot() {
        super("Carrot", VegType.ROOT);
        setInstructions("plant 3-5 every week");
    }

    @Override
    public void feed() {
        System.out.println("Harvest at desired maturity. You can store carrots in the ground.");

    }

    @Override
    public void water() {
        System.out.println("Fertilize 5-6 weeks after planting");
    }

    @Override
    public void harvest() {
        System.out.println("Water one inch per week");
    }
}
