package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItemResponse {
    private Item item;
    private List<OrderItem> orderItems;

    public OrderItemResponse() {}

    public OrderItemResponse( Item item, List<OrderItem> orderItems) {
        this.item = item;
        this.orderItems = orderItems;
    }

    public Item getItem() {
        return item;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}