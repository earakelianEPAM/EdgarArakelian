package com.epam.tc.hw7.entities;

import lombok.Value;

@Value
public class User {
    private final String name;
    private final String password;
    private final String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }
}
