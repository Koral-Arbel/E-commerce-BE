package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;

import java.util.List;

public interface OrderRepository {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    Order getOrderById(Long id);
    void deleteOrderById(Long id);
    Long getOpenOrderForUserId(Long userId);
    List<Order> getClosedOrderByUserId(Long userId);
}
