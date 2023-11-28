package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItemResponse {
    private Order order;
    private List<Item> items;

    public OrderItemResponse() {}

    public OrderItemResponse(Order order, List<Item> items) {
        this.order = order;
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderItem toOrderItem(){
        return new OrderItem(
                this.order.getId(),
                this.order.getUserId(),
                this.order.getId(),
                this.items.get(0).getId(),
                this.items.get(0).getPrice() * this.items.size(),
                this.items.size()
                );
    }
}