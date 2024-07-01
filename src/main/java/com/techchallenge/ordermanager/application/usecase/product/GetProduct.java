package com.techchallenge.ordermanager.application.usecase.product;

import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.application.presenters.IProductPresenter;
import com.techchallenge.ordermanager.domain.entities.Product;

import java.util.UUID;

public class GetProduct {
    private final IProductPresenter<?, Product> presenter;
    private final IProductGateway productGateway;

    public GetProduct(IProductPresenter<?, Product> presenter, IProductGateway productGateway) {
        this.presenter = presenter;
        this.productGateway = productGateway;
    }

    public void execute(UUID productId) {
        Product product = this.productGateway.getById(productId);

        this.presenter.output(product);
    }
}
