package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws Exception {
        return orderItemService.createOrderItem(orderItemRequest);
    }

    @PutMapping("/update")
    public void updateCreateOrderItemById(@PathVariable Long customerOrderId, @RequestBody OrderItem orderItem) {
        orderItemService.updateCreateOrderItemById(customerOrderId, orderItem);
}

    @DeleteMapping("/delete/{id}")
    public void deleteOrderItemById(@PathVariable Long id) {
        orderItemService.deleteOrderItemById(id);
    }
    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }
}
