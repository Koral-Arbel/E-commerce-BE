package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomerOrder;
import com.ecommerce.ecommerce.model.CustomerOrderRequest;

public interface CustomerOrderService {
    Long createCustomerOrder(CustomerOrder customerOrder);

    void updateCustomerOrderById(Long id, CustomerOrderRequest customerOrderRequest) throws Exception;

    void deleteCustomerOrderById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
}
