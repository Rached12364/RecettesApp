package com.example.t7;

public class Recette {
    private String nom;
    private String description;
    private String tag;
    private String ingredients;
    private String etapes;
    private String imageUrl;

    public Recette(String nom, String description, String tag,
                   String ingredients, String etapes, String imageUrl) {
        this.nom = nom;
        this.description = description;
        this.tag = tag;
        this.ingredients = ingredients;
        this.etapes = etapes;
        this.imageUrl = imageUrl;
    }

    public String getNom()          { return nom; }
    public String getDescription()  { return description; }
    public String getTag()          { return tag; }
    public String getIngredients()  { return ingredients; }
    public String getEtapes()       { return etapes; }
    public String getImageUrl()     { return imageUrl; }
}