package com.techchallenge.ordermanager.adapters.web.in.controller.product;

import com.techchallenge.ordermanager.core.domain.valueobjects.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInput {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private List<String> images;
}
