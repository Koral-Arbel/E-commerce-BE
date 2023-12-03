package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.ItemRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Long createOrder(Order order) {
        CustomUser user = getOrderByUserId(order.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("You must register first");
        }
        Long existingOpenOrderId = getOpenOrderForUser(order.getUserId());
        if (existingOpenOrderId != null) {
            throw new IllegalStateException("The user already has an open order in TEMP status");
        }
        Long orderId = orderRepository.createOrder(order);
        return orderId;
    }


    @Override
    public void updateOrderById(Order order) {
        orderRepository.updateOrderById(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteOrderById(orderId);

    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public CustomUser getOrderByUserId(Long id) {
        return userRepository.getCustomUserById(id);
    }

    @Override
    public Long getOpenOrderForUser(Long userId) {
        return orderRepository.getOpenOrderForUser(userId);
    }

    @Override
    public void processPayment(Long orderId) {
        Order order = orderRepository.getOrderById(orderId);
        order.setStatus(OrderStatus.CLOSE);
        orderRepository.updateOrderById(order);
    }

    @Override
    public void handleOutOfStockItem(Item existingItem) {
        if (existingItem != null) {
            if (existingItem.getAvailableStock() == 0) {
                // אם כמות המלאי ירדה ל-0, ניתן להוסיף פעולות נוספות כגון שליחת הודעה או יצירת לוג
                System.out.println("Item with id " + existingItem.getId() + " is out of stock.");
            }
        } else {
            throw new IllegalArgumentException("Existing item is null");
        }
    }

    @Override
    public Double calculateTotalPrice(Order order) {
        return calculateTotalPrice(order);
    }
}


