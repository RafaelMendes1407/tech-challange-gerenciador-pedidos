package com.techchallenge.ordermanager.infrastructure.controllers.order;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private UUID id;
    private List<OrderItemResponse> items;
}

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
class OrderItemResponse {
    private UUID productId;
    private int quantity;
}