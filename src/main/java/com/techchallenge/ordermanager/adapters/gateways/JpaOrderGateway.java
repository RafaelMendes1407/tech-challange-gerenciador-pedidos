package com.techchallenge.ordermanager.adapters.gateways;

import com.techchallenge.ordermanager.adapters.data.OrderData;
import com.techchallenge.ordermanager.adapters.data.OrderItemData;
import com.techchallenge.ordermanager.adapters.repository.OrderRepository;
import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.domain.OrderItem;
import com.techchallenge.ordermanager.core.domain.Product;
import com.techchallenge.ordermanager.core.domain.valueobjects.*;
import com.techchallenge.ordermanager.core.ports.database.OrderGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class JpaOrderGateway implements OrderGateway {
    private static final int INITIAL_VALUE_SEQ = 1;
    private final OrderRepository orderRepository;

    public JpaOrderGateway(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private static final AtomicInteger counter = new AtomicInteger(INITIAL_VALUE_SEQ);

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll().stream().map(this::mapToOrder).toList();
    }

    @Override
    public List<Order> getAllExceptFinished() {
        return orderRepository.findAll().stream()
                .map(this::mapToOrder)
                .filter(order -> order.getOrderStatus() != OrderStatus.FINALIZADO )
                .toList();
    }

    private Order mapToOrder(OrderData orderData) {

        var orderItems = orderData.getItems().stream().map(orderItemRequest -> {
            var product = new Product(new ProductId(orderItemRequest.getProductId()));
            var price = new Money(orderItemRequest.getPrice());
            var subTotal = new Money(orderItemRequest.getSubTotal());
            return OrderItem.OrderItemBuilder.anOrderItem()
                    .withProduct(product)
                    .withQuantity(orderItemRequest.getQuantity())
                    .withPrice(price)
                    .withId(new OrderItemId(orderItemRequest.getId()))
                    .build();
        }).toList();
        return Order.OrderBuilder.anOrder().withItems(orderItems)
                .withId(new OrderId(orderData.getId()))
                .withPickupCode(orderData.getPickUpCode())
                .withOrderStatus(orderData.getOrderStatus())
                .withPrice(new Money(orderData.getPrice()))
                .build();
    }
    public OrderItemData toOrderItemData(OrderItem orderItem) {
        var productId = orderItem.getProduct().getId().getValue();
        return OrderItemData.builder()
                .productId(productId)
                .quantity(orderItem.getQuantity())
                .subTotal(orderItem.getSubTotal().getAmount())
                .price(orderItem.getPrice().getAmount())
                .build();
    }

    private OrderData mapToOrderData(Order order) {

        var orderItemsEntity = order.getItems().stream().map(this::toOrderItemData).toList();

        var orderData = OrderData.builder()
                .orderStatus(order.getOrderStatus())
                .price(order.getPrice().getAmount())
                .items(orderItemsEntity)
                .pickUpCode(order.getPickupCode())
                .build();

        orderData.getItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderData));
        return orderData;
    }

    public Order add(Order order) {
        var pickUpCode = nextValue();
        order.setPickUpCodeInfo(order, pickUpCode);
        var orderData = this.mapToOrderData(order);
        OrderData orderSaved = orderRepository.save(orderData);
        return this.mapToOrder(orderSaved);
    }


    public static Integer nextValue() {
        return counter.getAndIncrement();
    }

    @Override
    public Order getById(UUID id) {
        return orderRepository.findById(id)
                .map(this::mapToOrder)
                .orElse(null);
    }
    @Override
    public void updateStatus(UUID id, OrderStatus orderStatus) {
        Order order = getById(id);
        order.updateStatus(orderStatus);
        var orderData = this.mapToOrderData(order);
        orderData.setId(order.getId().getValue());
        orderRepository.save(orderData);
    }
}
