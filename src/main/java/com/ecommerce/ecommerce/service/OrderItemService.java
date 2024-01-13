package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;

import java.util.List;

public interface OrderItemService {
    OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws Exception;
    void updateOrderItemById(Long id, OrderItem orderItem);
    OrderItem getOrderItemById(Long id);
    void deleteOrderItemById(Long itemId);
    List<ItemDto> getAllOrderItemsByUserId (Long userId);
    List<Item> getAllOrderItemsByOrderId(Long orderId);
    void updateOrderIdByUserId(Long userId, Long orderId);
    void deleteOrderItemsByUserId(Long userId);

    List<OrderItem> getAllItemsByOrderId(Long orderId);
}
