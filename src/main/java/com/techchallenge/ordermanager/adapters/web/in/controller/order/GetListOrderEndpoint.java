package com.techchallenge.ordermanager.adapters.web.in.controller.order;

import com.techchallenge.ordermanager.adapters.presenter.order.ListOrderPresenter;
import com.techchallenge.ordermanager.adapters.presenter.order.OrderPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.order.ListOrders;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class GetListOrderEndpoint implements BaseEndpoint {
    private final ListOrders useCase;
    private final ListOrderPresenter presenter;

    @GetMapping
    public ResponseEntity execute() {
        useCase.execute();
        return ResponseEntity.ok(presenter.getViewModel());
    }
}
