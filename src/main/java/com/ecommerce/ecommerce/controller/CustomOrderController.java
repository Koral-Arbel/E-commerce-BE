package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
import com.ecommerce.ecommerce.service.OrderItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customOrder")
public class CustomOrderController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItemResponse createCustomerOrder(@RequestBody OrderItemRequest orderItemRequest) throws JsonProcessingException {
        return orderItemService.createCustomOrder(orderItemRequest);
    }

    @PutMapping("/update")
    public OrderItemResponse updateOrderItemById(@RequestBody OrderItemRequest orderItemRequest){
        return orderItemService.updateCreateCustomOrderById(orderItemRequest);
}

    @DeleteMapping("/delete/{customerOrderId}")
    public void deleteCustomOrderById(@PathVariable Long id) {
        orderItemService.deleteCustomOrderById(id);
    }
    @GetMapping("/{customerOrderId}")
    public OrderItem getCustomOrderById(@PathVariable Long id) {
        return orderItemService.getCustomOrderById(id);
    }
}
