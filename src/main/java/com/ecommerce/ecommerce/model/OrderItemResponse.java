package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItemResponse {
    private Order order;
    private List<Item> items;
    private Double totalPrice;


    public OrderItemResponse() {}

    public OrderItemResponse(Order order, List<Item> items, Double totalPrice) {
        this.order = order;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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

    public void calculateTotalPrice() {
        if (items != null && !items.isEmpty()) {
            this.totalPrice = items.get(0).getPrice() * items.size();
        }
    }
}