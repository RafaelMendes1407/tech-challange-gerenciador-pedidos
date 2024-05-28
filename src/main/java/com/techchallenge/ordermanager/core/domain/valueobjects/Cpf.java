package com.techchallenge.ordermanager.core.domain.valueobjects;

public class Cpf {

    private String value;

    public Cpf(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    // TODO - implement cpf validation
}
