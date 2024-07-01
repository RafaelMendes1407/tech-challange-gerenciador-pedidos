package com.techchallenge.ordermanager.infrastructure.controllers.customer;

import com.techchallenge.ordermanager.application.presenters.ICustomerPresenter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerRegistrationPresenter implements ICustomerPresenter<CustomerResponse, UUID> {

    private CustomerResponse viewModel;

    @Override
    public CustomerResponse output(UUID customer) {
        this.viewModel = CustomerResponse.builder().id(customer.toString()).build();
        return viewModel;
    }

    @Override
    public CustomerResponse getViewModel() {
        return this.viewModel;
    }
}
