package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.presenters.IProductPresenter;
import com.techchallenge.ordermanager.domain.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class CreateProductPresenter implements IProductPresenter<ProductResponse, Product> {

    private ProductResponse viewModel;

    @Override
    public ProductResponse output(Product product) {
        return new ProductResponse(product);
    }

    @Override
    public ProductResponse getViewModel() {
        return this.viewModel;
    }
}
