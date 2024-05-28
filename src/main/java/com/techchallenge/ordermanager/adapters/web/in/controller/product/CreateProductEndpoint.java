package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.product.AddProduct;
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
public class CreateProductEndpoint implements BaseEndpoint {
    private final AddProduct<ProductInput> usecase;
    private final ProductPresenter presenter;

    @PostMapping
    public ResponseEntity execute(@RequestBody @Valid ProductInput productInput) {
        usecase.execute(productInput);

        return ResponseEntity.created(
                URI.create(
                        MessageFormat.format("/api/v1/products/{0}", presenter.getViewModel().getId())
                )
        ).body(presenter.getViewModel());
    }
}
