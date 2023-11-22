package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
import com.ecommerce.ecommerce.service.OrderItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws JsonProcessingException {
        return orderItemService.createOrderItem(orderItemRequest);

    }

    @PutMapping("/update")
    public OrderItemResponse updateCreateOrderItemById(@RequestBody OrderItemRequest orderItemRequest) throws JsonProcessingException{
        return orderItemService.updateCreateOrderItemById(orderItemRequest);
}

    @DeleteMapping("/delete/{orderItemId}")
    public void deleteOrderItemById(@PathVariable Long id) {
        orderItemService.deleteOrderItemById(id);
    }
    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }
}
