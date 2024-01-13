package com.ecommerce.ecommerce.model;

import java.util.List;

public class CustomerProfileResponse {
    private CustomUser customUser;
    private List<Item> favoriteItem;
    private List<ItemDto> orderItem;
    private List<OrderItemResponse> orderItemList;
    public CustomerProfileResponse(){}

    public CustomerProfileResponse(CustomUser customUser, List<Item> favoriteItem, List<ItemDto> orderItem, List<OrderItemResponse> orderItemList) {
        this.customUser = customUser;
        this.favoriteItem = favoriteItem;
        this.orderItem = orderItem;
        this.orderItemList = orderItemList;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public List<Item> getFavoriteItem() {
        return favoriteItem;
    }

    public List<ItemDto> getOrderItem() {
        return orderItem;
    }

    public List<OrderItemResponse> getOrderItemList() {
        return orderItemList;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public void setFavoriteItem(List<Item> favoriteItem) {
        this.favoriteItem = favoriteItem;
    }

    public void setOrderItem(List<ItemDto> orderItem) {
        this.orderItem = orderItem;
    }

    public void setOrderItemList(List<OrderItemResponse> orderItemList) {
        this.orderItemList = orderItemList;
    }
}