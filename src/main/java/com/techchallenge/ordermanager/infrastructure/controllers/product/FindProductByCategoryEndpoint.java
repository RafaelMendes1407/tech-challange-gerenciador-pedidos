package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.usecase.product.FindProductByCategory;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class FindProductByCategoryEndpoint implements IBaseEndpoint {

    private final FindProductByCategory usecase;
    private final FindProductByCategoryPresenter presenter;

    @GetMapping
    public ResponseEntity execute(@Param("category") String category) {
        usecase.execute(ProductCategory.valueOf(category));

        return ResponseEntity.ok(presenter.getViewModel());
    }

}
