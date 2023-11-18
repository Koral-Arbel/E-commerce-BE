package com.ecommerce.ecommerce.model;

public class CustomerOrderRequest {
    private CustomUserResponse customer;
    private CustomerOrder customerOrder;

    public CustomerOrderRequest(){}

    public CustomerOrderRequest(CustomUserResponse customer, CustomerOrder customerOrder) {
        this.customer = customer;
        this.customerOrder = customerOrder;
    }

    public CustomUserResponse getCustomer() {
        return customer;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomer(CustomUserResponse customer) {
        this.customer = customer;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
