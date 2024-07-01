package com.techchallenge.ordermanager.infrastructure.controllers.order;

import com.techchallenge.ordermanager.application.usecase.order.ListOrders;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class GetListOrderEndpoint implements IBaseEndpoint {
    private final ListOrders useCase;
    private final GetListOrderPresenter presenter;

    @GetMapping
    public ResponseEntity execute() {
        useCase.execute();
        return ResponseEntity.ok(presenter.getViewModel());
    }
}