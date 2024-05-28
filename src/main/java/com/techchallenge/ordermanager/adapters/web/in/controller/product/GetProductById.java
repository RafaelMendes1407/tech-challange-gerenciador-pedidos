package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.product.GetProduct;
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
public class GetProductById implements BaseEndpoint {

    private GetProduct<UUID> usecase;
    private ProductPresenter presenter;

    @GetMapping("/{productId}")
    public ResponseEntity execute(@PathVariable UUID productId) {
        usecase.execute(productId);

        return ResponseEntity.ok(presenter.getViewModel());
    }
}
