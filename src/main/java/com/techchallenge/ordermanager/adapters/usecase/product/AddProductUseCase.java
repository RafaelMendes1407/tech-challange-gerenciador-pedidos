package com.techchallenge.ordermanager.adapters.usecase.product;

import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.product.ProductInput;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.domain.valueobjects.BaseId;
import com.techchallenge.ordermanager.core.domain.valueobjects.Money;
import com.techchallenge.ordermanager.core.domain.valueobjects.Image;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductId;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.product.AddProduct;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class AddProductUseCase implements AddProduct<ProductInput> {

    private final ProductPresenter presenter;
    private final ProductGateway productGateway;


    public void execute(ProductInput request) {
        validateProduct(request);
        Product product = addProduct(request);

        presenter.output(product);
    }

    private void validateProduct(final ProductInput request) {
        if (productAlreadyExists(request))
            throw new ProductGateway.ProductAlreadyByNameExistsException();
    }

    private boolean productAlreadyExists(final ProductInput request) {
        // To do: Validation
        return false;
    }

    private Product addProduct(ProductInput request) {
        Product product = Product.ProductBuilder.aProduct()
                .withName(request.getName())
                .withCategory(request.getCategory())
                .withPrice(new Money(request.getPrice()))
                .withDescription(request.getDescription())
                .withImages(request.getImages().stream().map(Image::new).toList())
                .build();

        UUID id = productGateway.add(product).getValue();
        product.setId(new ProductId(id));
        return product;
    }
}
