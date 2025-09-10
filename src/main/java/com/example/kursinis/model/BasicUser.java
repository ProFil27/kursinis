package com.example.kursinis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BasicUser extends User{
    protected String address;
    protected List<FoodOrder> myOrders;
    protected List<Review> myReviews;
    protected List<Review> feedback;

    public BasicUser(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address) {
        super(username, password, name, surname, phoneNumber, isAdmin);
        this.address = address;
        this.myOrders = new ArrayList<>();
        this.myReviews = new ArrayList<>();
        this.feedback = new ArrayList<>();
    }


}
