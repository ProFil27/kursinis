package com.example.kursinis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
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
    @Transient
    private List<Cuisine> menu;

    public Restaurant(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address, List<Cuisine> menu) {
        super(username, password, name, surname, phoneNumber, isAdmin, address);
        this.menu = menu;
    }
}
