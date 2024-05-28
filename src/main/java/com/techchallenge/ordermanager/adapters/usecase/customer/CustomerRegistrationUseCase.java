package com.techchallenge.ordermanager.adapters.usecase.customer;

import com.techchallenge.ordermanager.adapters.presenter.customer.CustomerRegistrationPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.customer.CustomerInput;
import com.techchallenge.ordermanager.core.domain.Customer;
import com.techchallenge.ordermanager.core.domain.valueobjects.Cpf;
import com.techchallenge.ordermanager.core.domain.valueobjects.EmailAddress;
import com.techchallenge.ordermanager.core.domain.valueobjects.PersonName;
import com.techchallenge.ordermanager.core.ports.database.CustomerGateway;
import com.techchallenge.ordermanager.core.usecase.customer.CustomerRegistration;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CustomerRegistrationUseCase implements CustomerRegistration<CustomerInput> {
    private final CustomerRegistrationPresenter presenter;
    private final CustomerGateway customerGateway;

    @Override
    public void execute(CustomerInput customer) {
        this.validateCustomer(customer);
        UUID id = addCustomer(customer);
        presenter.output(id);
    }

    private void validateCustomer(final CustomerInput customer) {
        if (customerAlreadyExists(customer))
            throw new CustomerGateway.CustomerAlreadyByNameExistsException();
    }

    private boolean customerAlreadyExists(final CustomerInput customer) {
        // TODO: Validation
        return false;
    }

    private UUID addCustomer(CustomerInput request) {
        var cpf = new Cpf(request.getCpf());
        var email = new EmailAddress(request.getEmail());
        var name = new PersonName(request.getName());
        var customer = new Customer(cpf, email, name);
        return customerGateway.add(customer).getValue();
    }
}
