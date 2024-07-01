package com.techchallenge.ordermanager.infrastructure.controllers.product;

import com.techchallenge.ordermanager.application.presenters.IProductPresenter;
import com.techchallenge.ordermanager.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductByCategoryPresenter implements IProductPresenter<List<ProductResponse>, List<Product>> {

    private List<ProductResponse> viewModel;

    @Override
    public List<ProductResponse> output(List<Product> product) {
        this.viewModel = product.stream().map(ProductResponse::new).toList();
        return this.viewModel;
    }

    @Override
    public List<ProductResponse> getViewModel() {
        return null;
    }
}
