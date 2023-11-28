package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.Order;

public interface OrderService {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long id);
    Order getOrderById(Long id);
    CustomUser getOrderByUserId(Long userId);
    Long getOpenOrderForUser(Long userId);
}
