package com.techchallenge.ordermanager.infrastructure.controllers.order;

import com.techchallenge.ordermanager.application.usecase.order.CheckoutOrder;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.text.MessageFormat;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class CheckoutOrderEndpoint implements IBaseEndpoint {

    private final CheckoutOrder useCase;
    private final CheckoutOrderPresenter presenter;

    @PostMapping
    public ResponseEntity<OrderResponse> execute(@RequestBody @Valid OrderRequest request) {
        useCase.execute(request.toOrderEntitie());

        return ResponseEntity
                .created(
                        URI.create(
                                MessageFormat.format("/api/v1/orders/{0}", presenter.getViewModel().getId())
                        )
                )
                .body(presenter.getViewModel());
    }
}