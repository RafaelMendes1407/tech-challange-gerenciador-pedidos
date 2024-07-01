package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.Image;
import com.techchallenge.ordermanager.domain.entities.valueobjects.Money;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductId;
import jakarta.validation.constraints.NotBlank;
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
public class ProductRequest {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private List<String> images;

    public Product toProduct() {
        Product product = Product.ProductBuilder.aProduct()
                .withId(new ProductId(this.id))
                .withName(this.name)
                .withDescription(this.description)
                .withPrice(new Money(this.price))
                .withCategory(this.category)
                .withImages(this.images.stream().map(Image::new).toList())
                .build();

        return product;
    }
}