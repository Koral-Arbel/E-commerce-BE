package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;

public interface OrderService {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long orderId);
    Order getOrderById(Long orderId);
    CustomUser getOrderByUserId(Long userId);
    Long getOpenOrderForUser(Long userId);
    void processPayment(Long orderId);
    void handleOutOfStockItem(Item existingItem);
    Double calculateTotalPrice(Order order);
}
