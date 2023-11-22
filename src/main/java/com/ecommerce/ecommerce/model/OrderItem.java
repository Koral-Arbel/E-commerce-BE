package com.ecommerce.ecommerce.model;

public class OrderItem {
    private Long id;
    private Long userId;
    private Long itemId;
    private Double price;
    private int quantity;
    private Double totalPrice;
    private OrderStatus orderStatus;

    public OrderItem() {}

    public OrderItem(Long id, Long itemId, Double price, int quantity, OrderStatus orderStatus) {
        this.id = id;
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
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

    public void setUserId(Long userId) {
        this.userId = userId;
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
    public OrderItem toOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setItemId(itemId);
        orderItem.setPrice(price);
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(totalPrice);
        orderItem.setOrderStatus(orderStatus);
        return orderItem;
    }
}