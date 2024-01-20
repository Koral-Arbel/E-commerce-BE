package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.OrderDto;
import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderStatus;

import java.util.List;

public interface OrderItemRepository {
    Long createOrderItem(OrderItem orderItem);
    void updateOrderItemById(Long orderId, OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long orderId);
    List<OrderItem> getAllItemsByOrderId(Long orderId);

    List<OrderDto> getOrdersByStatus(OrderStatus status);

    void processPayment(Long orderId);

}
