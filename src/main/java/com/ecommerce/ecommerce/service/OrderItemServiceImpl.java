package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.OrderItemRepository;
import com.ecommerce.ecommerce.repository.ItemRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws JsonProcessingException {
        Item selectedItem = orderItemRequest.getItem();
        Long createdOrderItemId = selectedItem.getId();

        // Check if the product is already in the order
        OrderItem existingOrderItem = orderItemRepository.getOrderItemById(selectedItem.getId());
        if (existingOrderItem != null) {
            throw new IllegalArgumentException("The product is already on order " + selectedItem.getId());
        }

        Long createdOrderId = orderItemRequest.toOrderItem().getId();

        if (createdOrderItemId == null) {
            // If the item ID is null, create a new item
            createdOrderItemId = itemService.createItem(selectedItem).getId();
        } else {
            // If the item ID is not null, check if the item exists
            Item existingItem = itemService.getItemById(createdOrderItemId);
            if (existingItem == null) {
                throw new IllegalArgumentException("The product is already on order " + selectedItem.getId());
            }
        }

        // Get the updated item
        selectedItem = itemService.getItemById(createdOrderItemId);
        orderItemRequest.setItem(selectedItem);

        // Create the order item
        OrderItem orderItemToCreate = orderItemRequest.toOrderItem();
        orderItemRepository.createOrderItem(orderItemToCreate);

        // Retrieve the list of order items by order ID
        List<OrderItem> orderItems = orderItemRepository.getAllItemsByOrderId(createdOrderId);

        // Return the response
        return orderItemToCreate.toOrderItemResponse(selectedItem, orderItems);
    }




    @Override
    public OrderItemResponse updateCreateOrderItemById(OrderItemRequest orderItemRequest) {
        Long orderItemId = orderItemRequest.getItemId(); // Assuming you have a method to get the order item ID from the request
        OrderItem existingOrderItem = orderItemRepository.getOrderItemById(orderItemId);

        // Check if the order item exists
        if (existingOrderItem == null) {
            throw new IllegalArgumentException("Order item with ID " + orderItemId + " not found.");
        }

        // Update the order item properties with the new values from the request
        Item updatedItem = orderItemRequest.getItem();
        existingOrderItem.setPrice(updatedItem.getPrice());
        existingOrderItem.setQuantity(orderItemRequest.getQuantity());
        // Update other properties as needed

        // Save the updated order item back to the database
        orderItemRepository.updateCreateOrderItemById(existingOrderItem);

        // Retrieve the list of order items by order ID (assuming this method exists in your repository)
        List<OrderItem> orderItems = orderItemRepository.getAllItemsByOrderId(existingOrderItem.getOrderId());

        // You can return the updated order item response using the toOrderItemResponse method
        return existingOrderItem.toOrderItemResponse(updatedItem, orderItems);
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
