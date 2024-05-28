package com.techchallenge.ordermanager.adapters.presenter.order;

import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.ports.out.IPresenter;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderPresenter implements IPresenter<OrderPresenter.OrderOutput, Order> {

    private OrderOutput viewModel;

    @Override
    public OrderOutput getViewModel() {
        return this.viewModel;
    }

    @Override
    public void output(Order order) {
        List<OrderItemOutput> orderItems = new ArrayList<>();

        order.getItems().forEach(e -> {
            OrderItemOutput out = OrderItemOutput.builder()
                    .price(e.getPrice().getAmount().toPlainString())
                    .quantity(e.getQuantity())
                    .productId(e.getProduct().getId().getValue())
                    .subtotal(e.getSubTotal().getAmount().toPlainString())
                    .productName(e.getProduct().getName())
                    .build();

            orderItems.add(out);
        });

        this.viewModel = OrderOutput.builder()
                .id(order.getId().getValue())
                .price(order.getPrice().getAmount().toPlainString())
                .items(orderItems)
                .pickUpCode(order.getPickupCode())
                .orderStatus(order.getOrderStatus().name())
                .build();
    }


    @Getter
    @Builder
    public static class OrderOutput {
        private UUID id;
        private String price;
        private List<OrderItemOutput> items;
        private int pickUpCode;
        private String orderStatus;
    }

    @Getter
    @Builder
    public static class OrderItemOutput {
        private int quantity;
        private UUID productId;
        private String price;
        private String subtotal;
        private String productName;
    }
}
