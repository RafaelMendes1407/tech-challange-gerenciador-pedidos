package com.techchallenge.ordermanager.adapters.usecase.order;

import com.techchallenge.ordermanager.adapters.presenter.order.ListOrderPresenter;
import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.ports.database.OrderGateway;
import com.techchallenge.ordermanager.core.usecase.order.ListOrders;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListOrdersUseCase implements ListOrders {
    private ListOrderPresenter presenter;
    private OrderGateway orderGateway;

    @Override
    public void execute() {
        List<Order> orders = this.orderGateway.getAll();
        this.presenter.output(orders);
    }
}
