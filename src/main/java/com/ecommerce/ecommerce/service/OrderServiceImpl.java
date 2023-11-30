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
        return orderRepository.createOrder(order);
    }


    @Override
    public void updateOrderById(Order order) {
        updateOrderById(order);
    }


    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
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
    public Integer calculateTotalQuantity() {
        List<Item> items = itemRepository.getAllItems();
        int totalQuantity = 0;
        for (Item item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
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
}


