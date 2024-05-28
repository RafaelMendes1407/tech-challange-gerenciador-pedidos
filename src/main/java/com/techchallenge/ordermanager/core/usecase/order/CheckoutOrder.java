package com.techchallenge.ordermanager.core.usecase.order;

import com.techchallenge.ordermanager.core.domain.valueobjects.OrderId;

public interface CheckoutOrder<T> {
    void execute(T orderId);
}
