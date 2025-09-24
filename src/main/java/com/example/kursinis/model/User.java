package com.example.kursinis.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
public class User {
    protected int id;
    protected String username;
    protected String password;
    protected String name;
    protected String surname;
    protected String phoneNumber;
    protected LocalDate dateCreated;
    protected LocalDate dateModified;
    protected boolean isAdmin;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String surname, String phoneNumber, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password, String name, String surname, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
}


