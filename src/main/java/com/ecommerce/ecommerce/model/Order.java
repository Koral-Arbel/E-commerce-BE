package com.ecommerce.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private String shippingAddress;
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Long userId, LocalDateTime orderDate, String shippingAddress, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private Double calculateTotalPriceInternal(List<OrderItem> orderItems) {
      return orderItems.stream().mapToDouble(orderItem -> orderItem.getPrice() * orderItem.getQuantity()).sum();
    }
}