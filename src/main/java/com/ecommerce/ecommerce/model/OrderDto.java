package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderDto {
    private Order order;
    private List<OrderItem> orderItems;

    public OrderDto(){}

    public OrderDto(Order order, List<OrderItem> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public Order getOrder() {
        return order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}