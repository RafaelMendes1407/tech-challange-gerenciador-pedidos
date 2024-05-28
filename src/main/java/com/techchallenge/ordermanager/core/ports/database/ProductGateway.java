package com.techchallenge.ordermanager.core.ports.database;

import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductId;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {
    List<Product> getAll();
    ProductId add(Product product);
    Product getById(UUID id);
    List<Product> getByCategory(ProductCategory category);
    void update(Product product);
    void delete(UUID id);

    public interface BadRequest {}
    public interface NotFound {}

    public class ProductAlreadyByNameExistsException extends RuntimeException implements BadRequest {
    }

    public class ProductNotFoundException extends RuntimeException implements NotFound {
    }

}
