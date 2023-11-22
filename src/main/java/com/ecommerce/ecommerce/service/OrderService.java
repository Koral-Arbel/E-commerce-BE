package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long id);
    Order getOrderById(Long id);
}
