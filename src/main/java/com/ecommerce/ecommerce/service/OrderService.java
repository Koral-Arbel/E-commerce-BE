package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;

import java.util.List;

public interface OrderService {
    Long createOrder(Order orderDto) throws Exception;
    void updateOrderById(Order orderDto);
    Order getOrderById(Long id);
    void deleteOrderById(Long id);
    List<OrderItemResponse> getOrderListByUserId(Long userId) throws Exception;
    Long getOpenOrderForUserId(Long userId);
    List<OrderDto> getClosedOrderByUserId(Long userId) throws Exception;

    void processPayment(Long orderId);

    List<OrderDto> getAllOrdersByUserId(Long userId);

    void handleOutOfStockItem(Item existingItem);
    Double calculateTotalPrice(Order order);

    List<OrderDto> getOrderListsByUserId(Long userId) throws Exception;

    void deleteOrdersByUserId(Long id,Long userId);

    List<Order> getAllItemsByStatus(Long userId, OrderStatus status);
}
