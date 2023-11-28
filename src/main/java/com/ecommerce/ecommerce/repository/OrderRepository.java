package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;

public interface OrderRepository {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long id);
    Order getOrderById(Long id);
    Order getOrderByUserId(Long userId);
    Order getOpenOrderForUser(Long userId);
}
