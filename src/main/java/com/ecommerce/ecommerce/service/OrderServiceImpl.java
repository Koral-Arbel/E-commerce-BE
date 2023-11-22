package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.utils.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Order createOrder(Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(1L);
        orderItem.setItemId(2L);
        orderItem.setPrice(orderItem.getPrice());
        orderItem.setQuantity(orderItem.getQuantity());
        orderItem.setTotalPrice(orderItem.getTotalPrice());
        orderItem.setOrderStatus(order.getStatus());
        if (!isUserRegistered(order.getUserId())) {
            throw new UserNotRegisteredException("User is not registered. Cannot create order.");
        }
        // המשתמש רשום, ניצור הזמנה
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


    private boolean isUserRegistered(Long id) {
        // בדיקה האם קיים משתמש עם המזהה הנתון
        List<CustomUser> userList = Collections.singletonList(userRepository.getCustomUserById(id));
        return !userList.isEmpty();
    }
}
