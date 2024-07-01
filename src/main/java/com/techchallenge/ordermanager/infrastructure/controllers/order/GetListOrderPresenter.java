package com.techchallenge.ordermanager.infrastructure.controllers.order;

import com.techchallenge.ordermanager.application.presenters.IOrderPresenter;
import com.techchallenge.ordermanager.domain.entities.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListOrderPresenter implements IOrderPresenter<List<OrderResponse>, List<Order>> {


    @Override
    public List<OrderResponse> output(List<Order> order) {

        return null;
    }

    @Override
    public List<OrderResponse> getViewModel() {
        return null;
    }
}
