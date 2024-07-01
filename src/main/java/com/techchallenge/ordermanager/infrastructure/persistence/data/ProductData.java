package com.techchallenge.ordermanager.infrastructure.persistence.data;

import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductData {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "image", nullable = false)
    private List<String> images;

    public ProductData(UUID id) {
        this.id = id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}