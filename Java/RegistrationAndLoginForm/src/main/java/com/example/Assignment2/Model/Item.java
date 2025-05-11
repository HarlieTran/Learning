package com.example.Assignment2.Model;

public class Item {
    
    private String name;
    private String description;
    private String ingredients;
    private String tastingNotes;
    private String picture;


    public Item (String name, String description, String ingredients, String tastingNotes, String picture) {
        setName(name);
        setDescription(description);
        setPicture(picture);
        setIngredients(ingredients);
        setTastingNotes(tastingNotes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(String tastingNotes) {
        this.tastingNotes = tastingNotes;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
}
