package com.example.kursinis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private int id;
    private int rating;
    private String text;

    public Review(int rating, String text) {
        this.rating = rating;
        this.text = text;
    }
}
