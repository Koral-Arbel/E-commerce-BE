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
    private Item item;

    public OrderItem() {}

    public OrderItem(Long id, Long orderId, Long itemId, Double price, int quantity, Double totalPrice, OrderStatus orderStatus) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderItemResponse toOrderItemResponse(CustomUser customUser, List<OrderItem> orderItemList) {
        return new OrderItemResponse(customUser, orderItemList);
    }
}