package com.techchallenge.ordermanager.infrastructure.persistence.repository;

import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.infrastructure.persistence.data.ProductData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductData, UUID> {
    List<ProductData> findAll();
    List<ProductData> findByCategory(ProductCategory category);
}
