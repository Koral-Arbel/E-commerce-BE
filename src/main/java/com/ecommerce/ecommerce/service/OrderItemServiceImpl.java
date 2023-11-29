package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
   @Autowired
    OrderService orderService;
   @Autowired
    ItemService itemService;
    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws Exception {
        if (orderItemRequest == null) {
            throw new IllegalArgumentException("OrderItemRequest is null");
        }

        // Retrieve item information
        Item itemInformation = itemService.getItemById(orderItemRequest.getItemId());
        if (itemInformation == null) {
            throw new NotFoundException("Item with id " + orderItemRequest.getItemId() + " not found");
        }

        // Check item availability
        if (itemInformation.getAvailableStock() <= 0) {
            throw new IllegalArgumentException("Item is not available in stock");
        }

        Long orderId = orderService.getOpenOrderForUser(orderItemRequest.getUserId());

        if (orderId == null) {
            LocalDateTime date = LocalDateTime.now();
            Order newOrder = new Order(null, orderItemRequest.getUserId(), date, null, OrderStatus.TEMP);
            orderId = orderService.createOrder(newOrder);
        }

        Order openOrder = orderService.getOrderById(orderId);

        // Create an order item
        OrderItem orderItem = new OrderItem(
                null,
                orderItemRequest.getUserId(),
                openOrder.getId(),
                orderItemRequest.getItemId(),
                itemInformation.getPrice(),
                orderItemRequest.getQuantity()
        );

        // Update available stock and create the order item
        itemService.updateAvailableStock(itemInformation.getId(), itemInformation.getAvailableStock() - 1);
        orderItemRepository.createOrderItem(orderItem);

        // Fetch the updated order items for the order
        List<Item> orderItems = itemService.getItemsByOrderId(openOrder.getId());

        // Calculate total price dynamically
        Double totalPrice = itemInformation.getPrice() * orderItemRequest.getQuantity();

        // Create the response DTO
        OrderItemResponse orderItemResponse = new OrderItemResponse(openOrder, orderItems, totalPrice);
        return orderItemResponse;
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
