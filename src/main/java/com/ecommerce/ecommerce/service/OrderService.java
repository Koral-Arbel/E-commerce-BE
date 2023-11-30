package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    void deleteOrderById(Long id);
    Order getOrderById(Long id);
    CustomUser getOrderByUserId(Long userId);
    Long getOpenOrderForUser(Long userId);

    Integer calculateTotalQuantity();

    void handleOutOfStockItem(Item existingItem);
}
