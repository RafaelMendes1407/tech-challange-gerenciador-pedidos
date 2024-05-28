package com.techchallenge.ordermanager.adapters.presenter.product;

import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.ports.out.IPresenter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductPresenter implements IPresenter<ProductPresenter.ProductOutput, Product> {

    private ProductOutput viewModel;

    @Override
    public ProductOutput getViewModel() {
        return this.viewModel;
    }

    @Override
    public void output(Product product) {
        this.viewModel = new ProductOutput(product);
    }

    @Getter
    @AllArgsConstructor
    public static class ProductOutput {
        private String id;
        private String description;
        private String name;
        private BigDecimal price;
        private String category;
        private List<String> images = new ArrayList<>();

        public ProductOutput(Product product) {
            this.id = product.getId().getValue().toString();
            this.description = product.getDescription();
            this.category = product.getCategory().toString();
            this.price = product.getPrice().getAmount();
            this.name = product.getName();
            product.getImages().forEach(e -> images.add(e.toString()));
        }
    }
}
