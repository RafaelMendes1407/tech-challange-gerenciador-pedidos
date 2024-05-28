package com.techchallenge.ordermanager.adapters.presenter.order;

import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.ports.out.IPresenter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListOrderPresenter implements IPresenter<List<OrderPresenter.OrderOutput>, List<Order>> {

    private List<OrderPresenter.OrderOutput> viewModel;

    @Override
    public List<OrderPresenter.OrderOutput> getViewModel() {
        return this.viewModel;
    }

    @Override
    public void output(List<Order> orders) {
        this.viewModel = new ArrayList<OrderPresenter.OrderOutput>();
        OrderPresenter orderPresenter = new OrderPresenter();
        for (Order order : orders) {
            orderPresenter.output(order);
            this.viewModel.add(orderPresenter.getViewModel());
        }
    }
}
