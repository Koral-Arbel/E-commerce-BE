package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.OrderItemRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws Exception {
        CustomUser selectedCustomUser = orderItemRequest.getCustomUser();
        CustomUser customerForResponse = null;

        if (selectedCustomUser == null || selectedCustomUser.getId() == null) {
            throw new Exception("Can't create customerOrder with invalid custom user");
        }

        CustomUser existingCustomer = userService.getCustomUserById(selectedCustomUser.getId());
        if (existingCustomer != null) {
            // Create the order item
            OrderItem orderItemToCreate = orderItemRequest.toOrderItem();
            orderItemRepository.createOrderItem(orderItemToCreate);

            customerForResponse = existingCustomer;
        } else {
            throw new Exception("Can't create customerOrder with non-existing customer id " + selectedCustomUser);
        }
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
