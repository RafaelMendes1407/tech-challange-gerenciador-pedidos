package com.techchallenge.ordermanager.domain.entities;

import com.techchallenge.ordermanager.domain.entities.valueobjects.Cpf;
import com.techchallenge.ordermanager.domain.entities.valueobjects.CustomerId;
import com.techchallenge.ordermanager.domain.entities.valueobjects.EmailAddress;
import com.techchallenge.ordermanager.domain.entities.valueobjects.PersonName;

public class Customer extends BaseEntity<CustomerId> {
    private Cpf cpf;
    private EmailAddress email;
    private PersonName name;

    public Customer(Cpf cpf, EmailAddress email, PersonName name) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }
    public Customer( CustomerId id, Cpf cpf, EmailAddress email, PersonName name) {
        super.setId(id);
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public PersonName getName() {
        return name;
    }
}
