package com.ecommerce.ecommerce.model;

import java.util.List;

public class CustomUserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private OrderStatus status;

    public CustomUserResponse(){}

    public CustomUserResponse(Long id, String firstName, String lastName, String email, OrderStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
