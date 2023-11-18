package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private UserService userService;
    @Override
    public Long createCustomerOrder(CustomerOrder customerOrder) {
       return customerOrderRepository.createCustomerOrder(customerOrder);
    }

    @Override
    public void updateCustomerOrderById(Long id, CustomerOrderRequest customerOrderRequest) throws Exception {
        if (customerOrderRequest != null) {
            CustomUser existCustomer = userService.getCustomUserById(customerOrderRequest.getCustomerOrder().getId());
            if (existCustomer != null) {
                CustomerOrder customerOrder = customerOrderRepository.getCustomerOrderById(existCustomer.getId());
                if (customerOrder.getStatus().equals(OrderStatus.TEMP)) {
                    customerOrder.setStatus(OrderStatus.CLOSE);
                    customerOrderRepository.updateCreateCustomerOrderById(id, customerOrder);
                } else {
                    throw new Exception("Status Already Closed");
                }
            } else {
                throw new Exception("customer does not exist");
            }
        } else {
            throw new Exception("order is empty");
        }
    }

    @Override
    public void deleteCustomerOrderById(Long id) {

    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return null;
    }
}
