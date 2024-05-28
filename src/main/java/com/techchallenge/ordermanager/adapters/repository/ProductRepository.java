package com.techchallenge.ordermanager.adapters.repository;

import com.techchallenge.ordermanager.adapters.data.ProductData;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductData, UUID> {
    List<ProductData> findAll();
    List<ProductData> findByCategory(ProductCategory category);
}
