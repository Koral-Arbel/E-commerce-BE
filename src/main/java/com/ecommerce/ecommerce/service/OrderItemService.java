package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemResponse;

public interface OrderItemService {
    OrderItemResponse createOrderItem(OrderItem orderItem) throws Exception;
    void updateCreateOrderItemById(Long customerOrderId, OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id);
}
