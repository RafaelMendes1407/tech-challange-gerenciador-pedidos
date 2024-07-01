package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.usecase.product.GetProduct;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class GetProductByIdEndpoint implements IBaseEndpoint {

    private GetProduct usecase;
    private GetProductByIdPresenter presenter;

    @GetMapping("/{productId}")
    public ResponseEntity execute(@PathVariable UUID productId) {
        usecase.execute(productId);

        return ResponseEntity.ok(presenter.getViewModel());
    }
}