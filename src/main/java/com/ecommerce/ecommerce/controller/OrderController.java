package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void updateOrder(@RequestBody Order order, @RequestBody List<OrderItem>orderItems) {
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

    @PostMapping("/{orderId}/processPayment")
    public ResponseEntity<String> processPayment(@PathVariable Long orderId) {
        try {
            orderService.processPayment(orderId);
            return new ResponseEntity<>("Payment processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to process payment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
