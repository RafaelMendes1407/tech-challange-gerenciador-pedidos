package com.techchallenge.ordermanager.infrastructure.controllers.order;

import com.techchallenge.ordermanager.application.presenters.IOrderPresenter;
import com.techchallenge.ordermanager.domain.entities.Order;
import org.springframework.stereotype.Component;


@Component
public class CheckoutOrderPresenter implements IOrderPresenter<OrderResponse, Order> {

    private OrderResponse viewModel;

    @Override
    public OrderResponse output(Order order) {
        return null;
    }

    @Override
    public OrderResponse getViewModel() {
        return this.viewModel;
    }
}
