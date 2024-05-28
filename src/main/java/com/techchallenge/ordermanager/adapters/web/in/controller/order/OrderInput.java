package com.techchallenge.ordermanager.adapters.web.in.controller.order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInput {
    private List<OrderItemInput> items;
}
