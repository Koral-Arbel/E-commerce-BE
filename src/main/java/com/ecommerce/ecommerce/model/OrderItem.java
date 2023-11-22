package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItem {
    private Long id;
    private Long orderId;
    private Long itemId;
    private Double price;
    private int quantity;
    private Double totalPrice;
    private OrderStatus orderStatus;

    public OrderItem() {
    }

    public OrderItem(Long id, Long orderId, Double price, int quantity, OrderStatus orderStatus) {
        this.id = id;
        this.orderId = 0L;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderItemResponse toOrderItemResponse(Item item, List<OrderItem> orderItems) {
        return new OrderItemResponse(item, orderItems);
    }
}