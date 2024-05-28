package com.techchallenge.ordermanager.core.usecase.customer;

import com.techchallenge.ordermanager.core.domain.Customer;

public interface CustomerRegistration<T> {
    void execute(T customer);
}
