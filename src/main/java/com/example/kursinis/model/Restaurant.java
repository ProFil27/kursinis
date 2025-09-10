package com.example.kursinis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Restaurant extends BasicUser{
    private List<Cuisine> menu;

    public Restaurant(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address, List<Cuisine> menu) {
        super(username, password, name, surname, phoneNumber, isAdmin, address);
        this.menu = menu;
    }
}
