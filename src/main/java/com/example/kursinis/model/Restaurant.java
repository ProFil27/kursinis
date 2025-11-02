package com.example.kursinis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant extends BasicUser{
    @ManyToMany(mappedBy = "name", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuisine> menu;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodOrder> orders;

    public Restaurant(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address, List<Cuisine> menu) {
        super(username, password, name, surname, phoneNumber, isAdmin, address);
        this.menu = menu;
    }
}
