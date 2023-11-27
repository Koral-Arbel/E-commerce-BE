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
        Order createdOrder = orderRepository.createOrder(order);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(createdOrder.getId());  // כאן אני משתמש במזהה של הזמנה החדשה
        orderItem.setItemId(2L);
        orderItem.setPrice(25.0);
        orderItem.setQuantity(2);
        orderItem.setTotalPrice(orderItem.getPrice() * orderItem.getQuantity());
        if (!isUserRegistered(order.getUserId())) {
            throw new UserNotRegisteredException("User is not registered. Cannot create order.");
        }

        // המשתמש רשום, ניצור הזמנה
        orderRepository.createOrder(order);

        return order;

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
