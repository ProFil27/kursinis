package com.example.kursinis.model;

import jakarta.persistence.*;
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
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<FoodOrder> myOrders;
    @OneToMany(mappedBy = "commentOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Review> myReviews;
    @OneToMany(mappedBy = "feedbackUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
