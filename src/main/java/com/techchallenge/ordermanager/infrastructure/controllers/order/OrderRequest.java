package com.techchallenge.ordermanager.infrastructure.controllers.order;


import com.techchallenge.ordermanager.domain.entities.Order;
import com.techchallenge.ordermanager.domain.entities.OrderItem;
import com.techchallenge.ordermanager.domain.entities.Product;
import com.techchallenge.ordermanager.domain.entities.valueobjects.ProductId;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderItemRequest> items;


    public Order toOrderEntitie() {
        List<OrderItem> orderItems = this.items.stream().map(this::buildOrderItemsEntity).toList();

        return Order.OrderBuilder.anOrder()
                .withItems(orderItems)
                .build();
    }

    private OrderItem buildOrderItemsEntity(OrderItemRequest item) {

        Product product = new Product();
        product.setId(new ProductId(item.getProductId()));

        return OrderItem.OrderItemBuilder.anOrderItem()
                .withProduct(product)
                .withQuantity(item.getQuantity())
                .build();
    }

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class OrderItemRequest {
    private UUID productId;
    private int quantity;
}
