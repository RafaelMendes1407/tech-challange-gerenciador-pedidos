package com.techchallenge.ordermanager.application.usecase.order;

import com.techchallenge.ordermanager.application.gateways.IOrderGateway;
import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.application.presenters.IOrderPresenter;
import com.techchallenge.ordermanager.domain.entities.Order;
import com.techchallenge.ordermanager.domain.entities.Order.OrderBuilder;
import com.techchallenge.ordermanager.domain.entities.OrderItem;
import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.Money;
import com.techchallenge.ordermanager.domain.entities.valueobjects.OrderStatus;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductId;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOrder {

    private final IOrderGateway orderGateway;
    private final IProductGateway productGateway;
    private final IOrderPresenter<?, Order> presenter;

    public CheckoutOrder(IOrderGateway orderGateway, IProductGateway productGateway, IOrderPresenter<?, Order> presenter) {
        this.orderGateway = orderGateway;
        this.productGateway = productGateway;
        this.presenter = presenter;
    }

    public void execute(Order Order) {
        List<OrderItem> items = new ArrayList<>();
        Order.getItems().forEach(e -> {
            Product product = productGateway.getById(e.getProduct().getId().getValue());
            OrderItem item = OrderItem.OrderItemBuilder.anOrderItem()
                    .withPrice(product.getPrice())
                    .withQuantity(e.getQuantity())
                    .withProduct(this.cloneProduct(product))
                    .build();
            items.add(item);
        });

        Order order = OrderBuilder.anOrder()
                .withItems(items)
                .withOrderStatus(OrderStatus.CRIADO)
                .build();

        order = this.orderGateway.add(order);

        presenter.output(order);
    }

    // REFACT
    private Product cloneProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(new Money(product.getPrice().getAmount()));
        newProduct.setId(new ProductId(product.getId().getValue()));
        return newProduct;
    }
}
