package com.techchallenge.ordermanager.application.usecase.product;

import com.techchallenge.ordermanager.application.gateways.IProductGateway;

import java.util.UUID;

public class DeleteProduct {
    private IProductGateway productGateway;

    public DeleteProduct(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void execute(UUID product) {
        productGateway.delete(product);
    }
}
