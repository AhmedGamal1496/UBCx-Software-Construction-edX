package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Kitchen {

    private final static int INGREDIENT_PER_TACO = 3;
    private final static int DOLLAR_PER_INGREDIENT = 2;
    private int ingredient;
    private int tacoCount;
    private int balance;
    private boolean cookReady;

    public Kitchen(int initialIngredient, int initialTaco, int balance, boolean cookStatus) {
        ingredient = initialIngredient;
        tacoCount = initialTaco;
        cookReady = cookStatus;
        this.balance = balance;
    }

    // getters
    public int getIngredientCount() { return ingredient; }
    public int getTacoCount() { return tacoCount; }
    public boolean getCookState() { return cookReady; }
    public int getBalance() { return balance; }

    public void setCookStatus(boolean b) {
        cookReady = b;
    }

    // MODIFIES: this
    // EFFECTS:  number is added to tacoCount, and ingredient is decremented accordingly
    //           throws NoCookException if the cook is not ready (cookReady = false)
    public void makeTaco(int amount) throws NoCookException, NoIngredientException {
        if (!cookReady) {
            throw new NoCookException("The cook is not ready, yet");
        }
        else {
            if (ingredient - (INGREDIENT_PER_TACO * amount) < 0) {
                throw new NoIngredientException("We don't have enough ingredients!");
            } else {
                ingredient -= (INGREDIENT_PER_TACO * amount);
                tacoCount += amount;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: (amount) is added to the ingredient field, and the balance field
    //          is decremented accordingly
    //          throws NotEnoughMoneyException if there is not enough balance
    public void buyIngredients(int amount) throws NotEnoughMoneyException {
        if (balance - (DOLLAR_PER_INGREDIENT * amount) < 0) {
            throw new NotEnoughMoneyException("There is no money to buy ingredients!");
        }
        else {
            balance -= (DOLLAR_PER_INGREDIENT * amount);
            ingredient += amount;
        }
    }

  



}
