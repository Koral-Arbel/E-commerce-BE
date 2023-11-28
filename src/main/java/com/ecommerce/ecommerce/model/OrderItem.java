package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItem {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long itemId;
    private Double price;
    private int quantity;
    public OrderItem() {}

    public OrderItem(Long id, Long userId, Long orderId, Long itemId, Double price, int quantity) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderItemResponse toOrderItemResponse(Order order, List<Item> items) {
        return new OrderItemResponse(order, items);
    }
}