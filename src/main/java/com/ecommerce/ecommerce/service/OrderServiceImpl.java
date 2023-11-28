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
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

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
    public Order getOpenOrderForUser(Long userId) {
        return orderRepository.getOpenOrderForUser(userId);
    }
}
