package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderItemResponse {
    private CustomUser customUser;
    private List<OrderItem> orderItems;

    public OrderItemResponse() {}

    public OrderItemResponse(CustomUser customUser, List<OrderItem> orderItems) {
        this.customUser = customUser;
        this.orderItems = orderItems;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}