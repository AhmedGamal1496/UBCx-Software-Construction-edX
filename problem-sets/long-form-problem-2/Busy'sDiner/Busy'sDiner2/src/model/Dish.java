package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private List<String> ingredients = new ArrayList<>();
    private String name;
    private String description;
    private String recipe;

    public Dish(String name) {
        this.name = name;
        description = "";
        recipe = "";
    }

    public Dish(String name, String description, List ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    //getters
    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipe() {
        return recipe;
    }

    //setters
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
