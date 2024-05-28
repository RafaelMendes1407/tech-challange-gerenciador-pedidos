package com.techchallenge.ordermanager.adapters.usecase.order;

import com.techchallenge.ordermanager.adapters.presenter.order.OrderPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.order.OrderInput;
import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.domain.OrderItem;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.domain.valueobjects.Money;
import com.techchallenge.ordermanager.core.domain.valueobjects.OrderStatus;
import com.techchallenge.ordermanager.core.domain.valueobjects.ProductId;
import com.techchallenge.ordermanager.core.ports.database.OrderGateway;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;
import com.techchallenge.ordermanager.core.usecase.order.CheckoutOrder;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CheckoutOrderUsecase implements CheckoutOrder<OrderInput> {

    private OrderPresenter presenter;
    private OrderGateway orderGateway;
    private ProductGateway productGateway;

    @Override
    public void execute(OrderInput orderInput) {
        List<OrderItem> items = new ArrayList<>();
        orderInput.getItems().forEach(e -> {
            Product product = productGateway.getById(e.getProductId());
            OrderItem item = OrderItem.OrderItemBuilder.anOrderItem()
                    .withPrice(product.getPrice())
                    .withQuantity(e.getQuantity())
                    .withProduct(this.cloneProduct(product))
                    .build();
            items.add(item);
        });

        Order order = Order.OrderBuilder.anOrder()
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
