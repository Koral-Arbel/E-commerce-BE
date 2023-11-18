package com.ecommerce.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerOrder {
    private Long id;
    private Long userId;
    private LocalDateTime date;
    private String shippingAddress;
    private Double totalPrice;
    private OrderStatus status;

    public CustomerOrder(){}

    public CustomerOrder(Long id, Long userId, LocalDate date, String shippingAddress, Double totalPrice, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.date = date.atStartOfDay();
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
