package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.model.OrderItemRequest;
import com.ecommerce.ecommerce.model.OrderItemResponse;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    @CrossOrigin
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws Exception {
        return orderItemService.createOrderItem(orderItemRequest);
    }

    @PutMapping("/update")
    @CrossOrigin
    public void updateOrderItemById(@PathVariable Long customerOrderId, @RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItemById(customerOrderId, orderItem);
}

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public void deleteOrderItemById(@PathVariable Long id) {
        orderItemService.deleteOrderItemById(id);
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @GetMapping("/allOrderItems/{id}")
    @CrossOrigin
    public List<OrderItem> getAllItemsByOrderId(Long orderId){
        return orderItemService.getAllItemsByOrderId(orderId);
    }
}
