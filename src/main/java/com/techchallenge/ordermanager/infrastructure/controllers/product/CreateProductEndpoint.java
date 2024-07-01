package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.usecase.product.AddProduct;
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
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class CreateProductEndpoint implements IBaseEndpoint {
    private final AddProduct usecase;
    private final CreateProductPresenter presenter;

    @PostMapping
    public ResponseEntity execute(@RequestBody @Valid ProductRequest productInput) {
        usecase.execute(productInput.toProduct());

        return ResponseEntity.created(
                URI.create(
                        MessageFormat.format("/api/v1/products/{0}", presenter.getViewModel().getId())
                )
        ).body(presenter.getViewModel());
    }
}