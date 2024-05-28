package com.techchallenge.ordermanager.core.domain;

import com.techchallenge.ordermanager.core.domain.exception.InconsistenceOrderItemSubtotalException;
import com.techchallenge.ordermanager.core.domain.exception.InconsistenceProductPriceException;
import com.techchallenge.ordermanager.core.domain.valueobjects.Money;
import com.techchallenge.ordermanager.core.domain.valueobjects.OrderId;
import com.techchallenge.ordermanager.core.domain.valueobjects.OrderItemId;

import java.math.BigDecimal;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;

    private Product product;
    private  int quantity;
    private Money subTotal;

    private  Money price;

    public OrderId getOrderId() {
        return orderId;
    }
    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public void setSubTotal (Product product, int quantity){
        this.subTotal = product.getPrice().multiply(quantity);
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    public void validatePriceInfo(Money productPrice) {
        if (this.price.getAmount().compareTo(productPrice.getAmount()) != 0){
            throw new InconsistenceProductPriceException("The product price is incorrect");
        }
    }

    public void validateSubtotal(Money productPrice, int quantity) {
        var subtotal = productPrice.multiply(quantity);
        if (subtotal.getAmount().compareTo(this.subTotal.getAmount()) !=0){
            throw new InconsistenceOrderItemSubtotalException("The product price is incorrect");
        }
    }


    public static final class OrderItemBuilder {
        private OrderItemId id;
        private OrderId orderId;
        private Product product;
        private int quantity;
        private Money subTotal;
        private Money price;
        public OrderItemId getId() {
            return id;
        }

        public OrderId getOrderId() {
            return orderId;
        }

        public Product getProductId() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }


        public Money getSubTotal() {
            return subTotal;
        }



        private OrderItemBuilder() {
        }

        public static OrderItemBuilder anOrderItem() {
            return new OrderItemBuilder();
        }

        public OrderItemBuilder withId(OrderItemId id) {
            this.id = id;
            return this;
        }

        public OrderItemBuilder withOrderId(OrderId orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderItemBuilder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderItemBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemBuilder withPrice(Money price) {
            this.price = price;
            return this;
        }

        public OrderItem build() {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(id);
            orderItem.price = this.price;
            orderItem.quantity = this.quantity;
            orderItem.subTotal = new Money(this.price.getAmount().multiply(BigDecimal.valueOf(this.quantity)));
            orderItem.orderId = this.orderId;
            orderItem.product = this.product;
            return orderItem;
        }
    }
}
