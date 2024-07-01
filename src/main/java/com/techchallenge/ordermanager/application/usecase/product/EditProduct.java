package com.techchallenge.ordermanager.application.usecase.product;

import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.domain.entities.Product;

public class EditProduct {
    private final IProductGateway productGateway;

    public EditProduct(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    private void validateProduct(final Product product) {
        if (productAlreadyExists(product))
            throw new IProductGateway.ProductAlreadyByNameExistsException();
    }

    private boolean productAlreadyExists(final Product product) {
        // To do: Validation
        return false;
    }

    public void execute(Product product) {
        Object Image;
        this.productGateway.update(product);
    }
}
