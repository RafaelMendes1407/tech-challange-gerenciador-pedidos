package com.techchallenge.ordermanager.application.usecase.product;

import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.application.presenters.IProductPresenter;
import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductCategory;

import java.util.List;

public class FindProductByCategory {
    private final IProductPresenter<?, List<Product>> presenter;
    private final IProductGateway productGateway;

    public FindProductByCategory(IProductPresenter<?, List<Product>> presenter, IProductGateway productGateway) {
        this.presenter = presenter;
        this.productGateway = productGateway;
    }

    public void execute(ProductCategory category) {
        List<Product> products = this.productGateway.getByCategory(category);
        this.presenter.output(products);
    }
}
