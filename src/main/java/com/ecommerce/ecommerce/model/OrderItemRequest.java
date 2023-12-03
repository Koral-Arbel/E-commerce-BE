package com.ecommerce.ecommerce.model;

public class OrderItemRequest {
    private Long userId;
    private Long itemId;
    private Integer quantity;
    private String shippingAddress;

    public OrderItemRequest() {}

    public OrderItemRequest(Long userId, Long itemId, Integer quantity, String shippingAddress) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
