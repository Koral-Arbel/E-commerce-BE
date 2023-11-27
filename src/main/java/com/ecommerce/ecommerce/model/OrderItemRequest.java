package com.ecommerce.ecommerce.model;

public class OrderItemRequest {
    private CustomUser customUser;
    private OrderItem orderItem;

    public OrderItemRequest(CustomUser customUser, OrderItem orderItem) {
        this.customUser = customUser;
        this.orderItem = orderItem;
    }

    public OrderItemRequest(){}

    public CustomUser getCustomUser() {
        return customUser;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderItem toOrderItem() {
        if (this.orderItem == null || this.customUser == null) {
            System.out.println("Warning: orderItem or item is null. Returning a default OrderItem.");
            return new OrderItem();

        }

        return new OrderItem(
                this.orderItem.getId(),
                this.customUser.getId(),
                this.orderItem.getItemId(),
                this.orderItem.getPrice(),
                this.orderItem.getQuantity(),
                this.orderItem.getTotalPrice(),
                this.orderItem.getOrderStatus()
        );
    }
}