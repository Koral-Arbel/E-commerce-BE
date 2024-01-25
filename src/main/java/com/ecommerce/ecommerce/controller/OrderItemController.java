package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws Exception {
        return orderItemService.createOrderItem(orderItemRequest);
    }
    @CrossOrigin
    @PutMapping(value = "{id}/update")
    public void updateOrderItemById( @RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItemById(orderItem.getId(), orderItem);
    }
    @CrossOrigin
    @DeleteMapping(value = "/deleteItem/{itemId}")
    public void deleteOrderItemById(@PathVariable Long itemId) {
        orderItemService.deleteOrderItemById(itemId);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/allOrderItems/{id}")
    public List<OrderItem> getAllItemsByOrderId(Long orderId){
        return orderItemService.getAllItemsByOrderId(orderId);
    }
}
