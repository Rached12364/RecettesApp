package com.example.t7;

public class Recette {
    private String nom;
    private String description;
    private String tag;
    private String ingredients;
    private String etapes;
    private String imageUrl;
    private int duree;
    private int calories;
    private float note;

    public Recette(String nom, String description, String tag,
                   String ingredients, String etapes, String imageUrl,
                   int duree, int calories, float note) {
        this.nom = nom;
        this.description = description;
        this.tag = tag;
        this.ingredients = ingredients;
        this.etapes = etapes;
        this.imageUrl = imageUrl;
        this.duree = duree;
        this.calories = calories;
        this.note = note;
    }

    public String getNom()         { return nom; }
    public String getDescription() { return description; }
    public String getTag()         { return tag; }
    public String getIngredients() { return ingredients; }
    public String getEtapes()      { return etapes; }
    public String getImageUrl()    { return imageUrl; }
    public int getDuree()          { return duree; }
    public int getCalories()       { return calories; }
    public float getNote()         { return note; }
}