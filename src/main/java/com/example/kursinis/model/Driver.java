package com.example.kursinis.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Driver extends BasicUser{
    private LocalDate bDate;
    private String licesne;
    private Enum vehicleType;

    public Driver(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin, String address, LocalDate bDate) {
        super(username, password, name, surname, phoneNumber, isAdmin, address);
        this.bDate = bDate;
    }

}
