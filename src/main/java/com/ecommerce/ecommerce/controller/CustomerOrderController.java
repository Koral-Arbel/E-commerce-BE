package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.CustomerOrder;
import com.ecommerce.ecommerce.model.CustomerOrderRequest;
import com.ecommerce.ecommerce.service.CustomerOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public Long createCustomerOrder(@RequestBody CustomerOrder customerOrder) throws JsonProcessingException {
        return customerOrderService.createCustomerOrder(customerOrder);
    }

    @PutMapping("/update")
    public void updateCustomerOrder(@PathVariable Long id, @RequestBody CustomerOrderRequest customerOrderRequest) throws Exception{
        customerOrderService.updateCustomerOrderById(id, customerOrderRequest);
}

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerOrderService.deleteCustomerOrderById(id);
    }

    @GetMapping("/{customerId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long customerOrderId) {
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}
