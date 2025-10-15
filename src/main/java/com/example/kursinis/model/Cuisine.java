package com.example.kursinis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    private List<FoodOrder> dish;
    private double price;
    private Allergens allergens;

    public Cuisine(int id, double price, Allergens allergens) {
        this.id = id;
        this.price = price;
        this.allergens = allergens;
    }
}
