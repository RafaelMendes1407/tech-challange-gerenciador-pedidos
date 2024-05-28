package com.techchallenge.ordermanager.adapters.usecase.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ListProductPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.product.ProductInput;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.product.FindProductByCategory;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class FindProductByCategoryUseCase implements FindProductByCategory<ProductInput> {

    private ListProductPresenter presenter;
    private ProductGateway productGateway;

    @Override
    public void execute(ProductInput productInput) {
        List<Product> products = this.productGateway.getByCategory(productInput.getCategory());
        this.presenter.output(products);
    }
}
