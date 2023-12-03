package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    Long createOrderItem(OrderItem orderItem);
    void updateCreateOrderItemById(Long orderId, OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemByOrderId(Long orderId);
    List<OrderItem> getAllItemsByOrderId(Long orderId);

    void processPayment(Long orderId);

}
