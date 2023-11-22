package com.ecommerce.ecommerce.model;

public class FavoriteItemResponse {
    private Long id;
    private CustomUserResponse customUserResponse;
    private Item item;
    public FavoriteItemResponse(){}

    public FavoriteItemResponse(Long id, CustomUserResponse customUserResponse, Item item) {
        this.id = id;
        this.customUserResponse = customUserResponse;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public CustomUserResponse getCustomUserResponse() {
        return customUserResponse;
    }

    public Item getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomUserResponse(CustomUserResponse customUserResponse) {
        this.customUserResponse = customUserResponse;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
