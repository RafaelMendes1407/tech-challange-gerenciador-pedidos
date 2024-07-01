package com.techchallenge.ordermanager.application.gateways;

import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductId;

import java.util.List;
import java.util.UUID;

public interface IProductGateway {
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
