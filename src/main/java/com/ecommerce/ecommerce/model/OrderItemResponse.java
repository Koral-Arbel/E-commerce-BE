package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItemResponse {
    private Order order;
    private List<Item> items;
    private Double itemPrice;


    public OrderItemResponse() {
    }

    public OrderItemResponse(Order order, List<Item> items, Double itemPrice) {
        this.order = order;
        this.items = items;
        this.itemPrice = itemPrice;
    }

    public Order getOrder() {
        return order;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public OrderItem toOrderItem() {
        return new OrderItem(
                this.order.getId(),
                this.order.getUserId(),
                this.order.getId(),
                this.items.get(0).getId(),
                this.items.get(0).getPrice() * toOrderItem().getQuantity(),
                this.items.size()
        );
    }
}
