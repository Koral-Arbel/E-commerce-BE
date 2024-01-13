package com.ecommerce.ecommerce.model;

public class FavoriteItemResponse {
    private Long id;
    private CustomerProfileResponse customerProfileResponse;
    private Item item;
    public FavoriteItemResponse(){}

    public FavoriteItemResponse(Long id, CustomerProfileResponse customerProfileResponse, Item item) {
        this.id = id;
        this.customerProfileResponse = customerProfileResponse;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public CustomerProfileResponse getCustomUserResponse() {
        return customerProfileResponse;
    }

    public Item getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomUserResponse(CustomerProfileResponse customerProfileResponse) {
        this.customerProfileResponse = customerProfileResponse;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
