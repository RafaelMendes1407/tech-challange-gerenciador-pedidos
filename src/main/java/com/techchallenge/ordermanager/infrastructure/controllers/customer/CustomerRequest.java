package com.techchallenge.ordermanager.infrastructure.controllers.customer;

import com.techchallenge.ordermanager.domain.entities.Customer;
import com.techchallenge.ordermanager.domain.entities.valueobjects.Cpf;
import com.techchallenge.ordermanager.domain.entities.valueobjects.EmailAddress;
import com.techchallenge.ordermanager.domain.entities.valueobjects.PersonName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String name;
    private String cpf;
    private String email;

    public Customer toCustomer() {

        Cpf domainCpf = null;
        EmailAddress domainEmail = null;
        PersonName personName = null;

        if (Strings.isNotEmpty(this.cpf)) {
            domainCpf = new Cpf(this.cpf);
        }

        if (Strings.isNotEmpty(this.email)) {
            domainEmail = new EmailAddress(this.email);
        }

        if (Strings.isNotEmpty(this.name)) {
            personName = new PersonName(this.name);
        }

        Customer customer = new Customer(domainCpf, domainEmail, personName);
        return customer;
    }

}
