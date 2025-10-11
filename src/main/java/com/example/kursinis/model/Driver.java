package com.example.kursinis.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends BasicUser{
    private LocalDate bDate;
    private String licesne;
    private VehicleType vehicleType;

    public Driver(String username, String password, String name, String surname, String phoneNumber, String address, LocalDate bDate, String licesne, VehicleType vehicleType) {
        super(username, password, name, surname, phoneNumber, address);
        this.bDate = bDate;
        this.licesne = licesne;
        this.vehicleType = vehicleType;
    }
}
