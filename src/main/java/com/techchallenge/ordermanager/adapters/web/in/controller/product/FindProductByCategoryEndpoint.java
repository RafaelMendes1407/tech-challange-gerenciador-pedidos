package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ListProductPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.core.usecase.product.FindProductByCategory;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class FindProductByCategoryEndpoint implements BaseEndpoint {

    FindProductByCategory<ProductInput> usecase;
    ListProductPresenter presenter;

    @GetMapping
    public ResponseEntity execute(@Param("category") String category) {
        usecase.execute(ProductInput.builder().category(ProductCategory.valueOf(category)).build());

        return ResponseEntity.ok(presenter.getViewModel());
    }

}
