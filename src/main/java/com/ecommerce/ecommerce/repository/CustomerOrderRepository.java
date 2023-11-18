package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {
    Long createCustomerOrder(CustomerOrder customerOrder);
    void updateCreateCustomerOrderById(Long id, CustomerOrder customerOrder);
    void deleteCustomerOrderById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
    List<CustomerOrder> getAllCustomerByCustomerId(Long customerId);
}
