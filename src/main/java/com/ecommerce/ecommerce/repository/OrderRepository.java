package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderDto;
import com.ecommerce.ecommerce.model.OrderStatus;

import java.util.List;

public interface OrderRepository {
    Long createOrder(Order order);
    void updateOrderById(Order order);
    Order getOrderById(Long id);
    void deleteOrderById(Long id);
    Long getOpenOrderForUserId(Long userId);
    List<OrderDto> getAllOrdersByUserId(Long userId);
    List<Order> getOrdersByStatus(Long userId, OrderStatus status);
    void deleteOrdersByCustomerId(Long customerId);

}
