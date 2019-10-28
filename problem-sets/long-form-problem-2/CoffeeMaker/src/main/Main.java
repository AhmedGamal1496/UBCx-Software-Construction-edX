package main;

import model.CoffeeMaker;
import model.exceptions.WaterException;

public class Main {

    public static void main(String[] args){
        // TODO: complete the implementation of Main
        CoffeeMaker maker = new CoffeeMaker();

        try {
            maker.brew(2.5, 15);

            maker.pourCoffee();
            maker.pourCoffee();
            maker.pourCoffee();

            maker.setTimeSinceLastBrew(30);

            maker.pourCoffee();

            System.out.println(60 - maker.getTimeSinceLastBrew() + " minutes remaining to pour "
                        + maker.getCupsRemaining() + " cups");
        }
        catch (Exception e){
            System.out.println("Exception should not be caught here");
        }

        try {
            maker.brew(2.65, 14.0);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            maker.brew(2.3, 14.9);
        }
        catch (WaterException e) {
            System.out.println("water exception should not be called here");
        }
        catch (Exception e) {
            e.getMessage();
        }

        try {
            maker.pourCoffee();
            maker.pourCoffee();
            maker.setTimeSinceLastBrew(60);
            maker.pourCoffee();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            maker.brew(2.5, 15);
            for (int i=0; i<20; i++){
                maker.pourCoffee();
            }
            maker.pourCoffee();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}