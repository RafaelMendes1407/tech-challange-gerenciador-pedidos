package com.techchallenge.ordermanager.domain.entities.valueobjects;

public class EmailAddress {
    private String email;

//    to do: create email validation

    public EmailAddress(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}