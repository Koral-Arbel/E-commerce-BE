package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderService {
    Long createOrder(Order orderDto) throws Exception;
    void updateOrderById(Order orderDto);
    Order getOrderById(Long id);
    void deleteOrderById(Long orderId);
    List<OrderItemResponse> getOrderListByUserId(Long userId) throws Exception;
    Long getOpenOrderForUserId(Long userId);
    List<Order> getClosedOrderByUserId(Long userId);

    void processPayment(Long orderId);

    List<OrderDto> getAllOrdersByUserId(@PathVariable Long userId);
    void handleOutOfStockItem(Item existingItem);
    Double calculateTotalPrice(Order order);

    List<OrderDto> getOrderListsByUserId(Long userId) throws Exception;
}
