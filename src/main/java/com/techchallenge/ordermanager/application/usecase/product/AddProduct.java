package com.techchallenge.ordermanager.application.usecase.product;

import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.application.presenters.IProductPresenter;
import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductId;

import java.util.UUID;

public class AddProduct {

    private final IProductPresenter<?, Product> presenter;
    private final IProductGateway productGateway;

    public AddProduct(IProductPresenter<?, Product> presenter, IProductGateway productGateway) {
        this.presenter = presenter;
        this.productGateway = productGateway;
    }

    public void execute(Product product) {
        validateProduct(product);
        Product prod = addProduct(product);

        presenter.output(product);
    }

    private void validateProduct(final Product product) {
        if (productAlreadyExists(product))
            throw new IProductGateway.ProductAlreadyByNameExistsException();
    }

    private boolean productAlreadyExists(final Product product) {
        // To do: Validation
        return false;
    }

    private Product addProduct(Product product) {
        UUID id = productGateway.add(product).getValue();
        product.setId(new ProductId(id));
        return product;
    }
}
