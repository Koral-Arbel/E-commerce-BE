package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderDto;
import com.ecommerce.ecommerce.model.OrderItem;
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
    @PutMapping(value = "/update")
    public void updateOrder(@RequestBody Order order, @RequestBody List<OrderItem>orderItems) {
        orderService.updateOrderById(order);
    }
    @CrossOrigin
    @DeleteMapping(value = "/delete/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }
    @CrossOrigin
    @GetMapping(value = "/{userId}/statusOrder")
    public Order getOrderById(@PathVariable Long userId) {
        return orderService.getOrderById(userId);
    }
    @CrossOrigin
    @GetMapping(value = "/openOrder/{userId}")
    public Long getOpenOrderByUserId(@PathVariable Long userId){
        return orderService.getOpenOrderForUserId(userId);
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
}
