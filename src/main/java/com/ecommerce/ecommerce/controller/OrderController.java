package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Long createOrder(@RequestBody Order order) {
       return orderService.createOrder(order);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrderById(order);
}

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
}
