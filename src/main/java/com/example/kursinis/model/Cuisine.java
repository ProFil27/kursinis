package com.example.kursinis.model;

public class Cuisine {
    private int id;
    private double price;
    private Allergens allergens;

    public Cuisine(int id, double price, Allergens allergens) {
        this.id = id;
        this.price = price;
        this.allergens = allergens;
    }
}
