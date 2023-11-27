package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;

import java.util.List;

public interface OrderItemRepository {
    OrderItem createOrderItem(OrderItem orderItem);
    void updateCreateOrderItemById(Long orderId, OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getAllItemsByOrderId(Long id);

}
