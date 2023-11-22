package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderItemService {
    OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws JsonProcessingException;
    OrderItemResponse updateCreateOrderItemById(OrderItemRequest orderItemRequest);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id);
}
