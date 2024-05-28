package com.techchallenge.ordermanager.adapters.presenter.product;

import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.ports.out.IPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListProductPresenter implements IPresenter<List<ProductPresenter.ProductOutput>, List<Product>> {

    private List<ProductPresenter.ProductOutput> viewModel = new ArrayList<>();

    @Override
    public List<ProductPresenter.ProductOutput> getViewModel() {
        return this.viewModel;
    }

    @Override
    public void output(List<Product> object) {
        ProductPresenter productPresenter = new ProductPresenter();

        for (Product product: object) {
            productPresenter.output(product);
            this.viewModel.add(productPresenter.getViewModel());
        }
    }
}
