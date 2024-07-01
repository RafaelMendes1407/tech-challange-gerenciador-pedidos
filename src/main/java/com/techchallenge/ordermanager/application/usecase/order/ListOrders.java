package com.techchallenge.ordermanager.application.usecase.order;

import com.techchallenge.ordermanager.application.gateways.IOrderGateway;
import com.techchallenge.ordermanager.application.presenters.IOrderPresenter;
import com.techchallenge.ordermanager.domain.entities.Order;

import java.util.List;

public class ListOrders {

    private final IOrderGateway gateway;
    private final IOrderPresenter<?, List<Order>> presenter;

    public ListOrders(IOrderGateway gateway, IOrderPresenter<?, List<Order>> presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    public void execute() {
        List<Order> orders = this.gateway.getAll();
        this.presenter.output(orders);
    }
}
