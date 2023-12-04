package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;

import java.util.List;

public interface OrderItemService {
    OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws Exception;
    void updateOrderItemById(Long customerOrderId, OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getAllItemsByOrderId(Long orderId);
}
