package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderDto;

public interface OrderRepository {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long id);
    Order getOrderById(Long id);
    Order getOrderByUserId(Long userId);
    Long getOpenOrderForUserId(Long userId);
}
