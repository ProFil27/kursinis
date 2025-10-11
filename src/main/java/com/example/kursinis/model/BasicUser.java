package com.example.kursinis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BasicUser extends User{
    protected String address;
    @Transient
    protected List<FoodOrder> myOrders;
    @Transient
    protected List<Review> myReviews;
    @Transient
    protected List<Review> feedback;

    public BasicUser(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address) {
        super(username, password, name, surname, phoneNumber, isAdmin);
        this.address = address;
        this.myOrders = new ArrayList<>();
        this.myReviews = new ArrayList<>();
        this.feedback = new ArrayList<>();

    }

    public BasicUser(String username, String password, String name, String surname, String phoneNumber, String address) {
        super(username, password, name, surname, phoneNumber);
        this.address = address;
        this.myOrders = new ArrayList<>();
        this.myReviews = new ArrayList<>();
        this.feedback = new ArrayList<>();

    }


}
