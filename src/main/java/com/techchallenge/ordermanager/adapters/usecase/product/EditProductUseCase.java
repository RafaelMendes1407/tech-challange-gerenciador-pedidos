package com.techchallenge.ordermanager.adapters.usecase.product;

import com.techchallenge.ordermanager.adapters.web.in.controller.product.ProductInput;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.domain.valueobjects.Money;
import com.techchallenge.ordermanager.core.domain.valueobjects.Image;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductId;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.product.EditProduct;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditProductUseCase implements EditProduct<ProductInput> {

    private ProductGateway productGateway;

    private void validateProduct(final ProductInput request) {
        if (productAlreadyExists(request))
            throw new ProductGateway.ProductAlreadyByNameExistsException();
    }

    private boolean productAlreadyExists(final ProductInput request) {
        // To do: Validation
        return false;
    }

    @Override
    public void execute(ProductInput productInput) {
        this.productGateway.update(Product.ProductBuilder.aProduct()
                .withName(productInput.getName())
                .withId(new ProductId(productInput.getId()))
                .withCategory(productInput.getCategory())
                .withPrice(new Money(productInput.getPrice()))
                .withDescription(productInput.getDescription())
                .withImages(productInput.getImages().stream().map(Image::new).toList())
                .build());
    }
}
