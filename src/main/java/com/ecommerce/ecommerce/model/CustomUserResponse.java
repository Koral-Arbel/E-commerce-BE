package com.ecommerce.ecommerce.model;

import java.util.List;

public class CustomUserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<FavoriteItem> favoriteItems;
    private List<Order> orders;
    private OrderStatus status;

    public CustomUserResponse(){}

    public CustomUserResponse(Long id, String firstName, String lastName, String email, List<FavoriteItem> favoriteItems, List<Order> orders, OrderStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteItems = favoriteItems;
        this.orders = orders;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<FavoriteItem> getFavoriteItems() {
        return favoriteItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriteItems(List<FavoriteItem> favoriteItems) {
        this.favoriteItems = favoriteItems;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
