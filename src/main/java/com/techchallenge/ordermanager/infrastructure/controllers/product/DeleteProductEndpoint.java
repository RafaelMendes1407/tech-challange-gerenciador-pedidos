package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.usecase.product.DeleteProduct;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
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
public class DeleteProductEndpoint implements IBaseEndpoint {

    private final DeleteProduct useCase;

    @DeleteMapping("/{productId}")
    public ResponseEntity execute(@PathVariable final UUID productId) {
        useCase.execute(productId);
        return ResponseEntity.noContent().build();
    }
}
