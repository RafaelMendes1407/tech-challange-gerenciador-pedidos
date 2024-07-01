package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private List<String> images;

    public ProductResponse(Product product) {
    }
}
