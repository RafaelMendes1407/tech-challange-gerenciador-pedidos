package com.techchallenge.ordermanager.infrastructure.persistence.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderItemEntityId.class)
@Table(name = "order_items")
@Entity
public class OrderItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    @JsonIgnore
    private OrderData order;

    private UUID productId;

    private BigDecimal subTotal;
    private BigDecimal price;

    private int  quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemData that = (OrderItemData) o;
        return id.equals(that.id) && order.equals(that.order);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, order);
    }
}