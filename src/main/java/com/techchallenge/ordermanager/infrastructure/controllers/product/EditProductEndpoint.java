package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.usecase.product.EditProduct;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class EditProductEndpoint implements IBaseEndpoint {

    private final EditProduct useCase;

    @PutMapping("/{productId}")
    public ResponseEntity execute(@PathVariable final UUID productId, @Valid @RequestBody ProductRequest request) {
        useCase.execute(request.toProduct());
        return ResponseEntity.noContent().build();
    }
}