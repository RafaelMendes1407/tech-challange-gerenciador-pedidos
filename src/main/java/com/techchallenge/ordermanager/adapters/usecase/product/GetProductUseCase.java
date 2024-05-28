package com.techchallenge.ordermanager.adapters.usecase.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.product.GetProduct;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class GetProductUseCase implements GetProduct<UUID> {

    private ProductPresenter presenter;
    private ProductGateway productGateway;

    @Override
    public void execute(UUID productId) {
        Product product = this.productGateway.getById(productId);

        this.presenter.output(product);
    }
}
