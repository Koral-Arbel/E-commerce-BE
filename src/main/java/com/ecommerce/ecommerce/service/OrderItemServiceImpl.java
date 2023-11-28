package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;
    @Override
    public OrderItemResponse createOrderItem(OrderItem orderItem) throws Exception {
        if (orderItem == null) {
            throw new Exception("OrderItem is Null");
        }
        Item itemInformation = itemService.getItemById(orderItem.getItemId());
        if (itemInformation == null) {
            throw new Exception("Item with id " + orderItem.getItemId() + " Not found");
        }

        if (itemInformation.getAvailableStock() <= 0) {
            throw new Exception("Item  is not available in stock");
        }

        Order openOrder = orderService.getOpenOrderForUser(orderItem.getUserId());
        if (openOrder == null) {
            LocalDateTime date = LocalDateTime.now();
            Order newOrder = new Order(null, orderItem.getUserId(), date, null, null, OrderStatus.TEMP);
            Long createOrderId = orderService.createOrder(newOrder);
            orderItem.setOrderId(createOrderId);
        } else {
            orderItem.setOrderId(openOrder.getId());
        }

        itemService.updateAvailableStock(itemInformation.getId(), itemInformation.getAvailableStock() - 1);
        orderItemRepository.createOrderItem(orderItem);

        return null;
    }
    @Override
    public void updateCreateOrderItemById(Long customerOrderId, OrderItem orderItem ) {
        orderItemRepository.updateCreateOrderItemById(customerOrderId, orderItem);
    }

    @Override
    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteOrderItemById(id);

    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.getOrderItemById(id);
    }
}
