package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
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
    @PutMapping(value = "/update")
    public void updateOrderItemById( @RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItemById(orderItem.getId(), orderItem);
    }
    @CrossOrigin
    @DeleteMapping(value = "/delete/{itemId}")
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
