package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;

public interface OrderService {
    Long createOrder(Order orderDto);
    void updateOrderById(Order orderDto);
    void deleteOrderById(Long orderId);
    Order getOrderById(Long orderId);
    CustomUser getOrderByUserId(Long userId);
    Long getOpenOrderForUserId(Long userId);
    void processPayment(Long orderId);
    void handleOutOfStockItem(Item existingItem);
    Double calculateTotalPrice(Order order);
}
