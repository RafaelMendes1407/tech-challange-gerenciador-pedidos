package com.techchallenge.ordermanager.adapters.web.in.controller.order;

import com.techchallenge.ordermanager.adapters.presenter.order.OrderPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.order.CheckoutOrder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.MessageFormat;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class CheckoutOrderEndpoint implements BaseEndpoint {

    private final CheckoutOrder<OrderInput> useCase;
    private final OrderPresenter presenter;

    @PostMapping
    public ResponseEntity execute(@RequestBody @Valid OrderInput request) {
        var orderItems = request.getItems().stream().map(orderItemRequest -> OrderItemInput.builder()
                .productId(orderItemRequest.getProductId())
                .quantity(orderItemRequest.getQuantity())
                .build()).toList();
        useCase.execute(OrderInput.builder().
                items(orderItems)
                .build());

        return ResponseEntity
                .created(
                        URI.create(
                                MessageFormat.format("/api/v1/orders/{0}", presenter.getViewModel().getId())
                        )
                )
                .body(presenter.getViewModel());
    }
}
