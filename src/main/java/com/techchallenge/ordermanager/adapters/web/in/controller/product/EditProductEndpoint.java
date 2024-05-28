package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.product.EditProduct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class EditProductEndpoint implements BaseEndpoint {

    private final EditProduct<ProductInput> useCase;

    @PutMapping("/{productId}")
    public ResponseEntity execute(@PathVariable final UUID productId, @Valid @RequestBody ProductInput request) {
        useCase.execute(ProductInput.builder()
                .id(productId)
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(request.getCategory())
                .images(request.getImages())
                .build());
        return ResponseEntity.noContent().build();
    }
}
