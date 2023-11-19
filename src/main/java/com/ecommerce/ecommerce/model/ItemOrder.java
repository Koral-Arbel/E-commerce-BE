package com.ecommerce.ecommerce.model;

public class ItemOrder {
    private Long id;
    private Long userId;
    private Long orderId;
    private String titleItem;
    private int quantity;
    private Double price;

    public ItemOrder(Long id, Long userId, Long orderId, String titleItem, int quantity, Double price) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.titleItem = titleItem;
        this.quantity = quantity;
        this.price = price;
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

    public String getTitleItem() {
        return titleItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
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

    public void setTitleItem(String titleItem) {
        this.titleItem = titleItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
