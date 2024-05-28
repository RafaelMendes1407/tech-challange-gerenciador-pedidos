package com.techchallenge.ordermanager.adapters.usecase.product;

import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.product.DeleteProduct;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class DeleteProductUseCase implements DeleteProduct<UUID> {

    private ProductGateway productGateway;

    @Override
    public void execute(UUID product) {
        productGateway.delete(product);
    }
}
