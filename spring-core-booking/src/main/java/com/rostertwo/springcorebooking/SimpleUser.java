package com.rostertwo.springcorebooking;

import model.User;

import java.io.Serializable;

public class SimpleUser implements User, Serializable {
    private static long idGenerator;
    private long id;
    private String name;
    private String email;

    public SimpleUser() {
    }

    public SimpleUser(String name, String email) {
        this.id = ++idGenerator;
        this.name = name;
        this.email = email;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
