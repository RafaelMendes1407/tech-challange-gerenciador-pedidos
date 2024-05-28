package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.product.DeleteProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class DeleteProductEndpoint implements BaseEndpoint {
    private final DeleteProduct<UUID> useCase;

    @DeleteMapping("/{productId}")
    public ResponseEntity execute(@PathVariable final UUID productId) {
        useCase.execute(productId);
        return ResponseEntity.noContent().build();
    }
}
