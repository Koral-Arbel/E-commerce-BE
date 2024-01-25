package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @CrossOrigin
    @PostMapping(value= "/create")
    public Long createOrder(@RequestBody Order order) throws Exception {
       return orderService.createOrder(order);
    }
    @CrossOrigin
    @PutMapping(value = "{id}/update")
    public void updateOrderById(@RequestBody Order order, @RequestBody List<OrderItem>orderItems) {
        orderService.updateOrderById(order);
    }
    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/orderTemp/{userId}")
    public Order getOrderById(@PathVariable Long userId) {
        return orderService.getOrderById(userId);
    }
    @CrossOrigin
    @GetMapping(value = "/openOrder/{userId}")
    public Long getOpenOrderByUserId(@PathVariable Long userId){
        return orderService.getOpenOrderForUserId(userId);
    }

    @CrossOrigin
    @GetMapping(value = "/byStatus/{status}")
    public List<Order> getOrdersByStatus(@PathVariable Long userId, @PathVariable OrderStatus status) {
        return orderService.getAllItemsByStatus(userId, status);
    }
    @CrossOrigin
    @PostMapping(value = "/processPayment/{orderId}")
    public ResponseEntity<String> processPayment(@PathVariable Long orderId) {
        try {
            orderService.processPayment(orderId);
            return new ResponseEntity<>("Payment processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to process payment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/{userId}/lastOrders")
    public List<OrderDto> getOrderListsByUserId(@PathVariable Long userId) throws Exception {
        return orderService.getOrderListsByUserId(userId);
    }

    @CrossOrigin
    @GetMapping(value = "/allOrders/{userId}")
    public List<OrderDto> getAllOrdersByUserId(@PathVariable Long userId) {
        return orderService.getAllOrdersByUserId(userId);
    }
}
