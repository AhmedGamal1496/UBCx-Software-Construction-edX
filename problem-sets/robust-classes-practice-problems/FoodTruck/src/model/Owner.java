package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Owner {

    private String name;
    private Kitchen kitchen;

    public Owner(String name, Kitchen kit) {
        this.name = name;
        kitchen = kit;
    }

    //getters
    public String getName() { return name; }
    public Kitchen getKitchen() { return kitchen; }

    // MODIFIES: this
    // EFFECTS: calls makeTaco on the kitchen, returns true
    //          otherwise catches an exception and return false
    public boolean orderMoreTacos(int amount) throws NoIngredientException {
        try {
            kitchen.makeTaco(amount);
            return true;
        }
        catch (NoCookException | NoIngredientException e) {
            e.getMessage();
        }

        return false;
    }

    //MODIFIES: this 
    //EFFECTS: calls buyIngredients on the kitchen, returns true.
    public boolean askForMoreIngredients(int amount) {
        try {
            kitchen.buyIngredients(amount);
            return true;
        }
        catch (NotEnoughMoneyException e) {
            e.getMessage();
        }

        return false;
    }
}
