package com.techchallenge.ordermanager.application.usecase.customer;

import com.techchallenge.ordermanager.application.gateways.ICustomerGateway;
import com.techchallenge.ordermanager.application.presenters.ICustomerPresenter;
import com.techchallenge.ordermanager.domain.entities.Customer;

import java.util.UUID;

public class CustomerRegistration {

    private final ICustomerGateway customerGateway;
    private final ICustomerPresenter<?, UUID> presenter;

    public CustomerRegistration(ICustomerGateway gateway, ICustomerPresenter<?, UUID> presenter) {
        this.customerGateway = gateway;
        this.presenter = presenter;
    }

    public void execute(Customer customer) {
        this.validateCustomer(customer);
        UUID id = addCustomer(customer);
        presenter.output(id);
    }

    private void validateCustomer(final Customer customer) {
        if (customerAlreadyExists(customer))
            throw new ICustomerGateway.CustomerAlreadyExistsException();
    }

    private boolean customerAlreadyExists(final Customer customer) {
        // TODO: Validation
        return false;
    }

    private UUID addCustomer(Customer customer) {
        return customerGateway.add(customer).getValue();
    }


}
