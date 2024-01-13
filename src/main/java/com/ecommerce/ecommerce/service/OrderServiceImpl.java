package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.ItemRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Long createOrder(Order order) throws Exception {
        List<OrderItemResponse> user = getOrderListByUserId(order.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("You must register first");
        }
        Long existingOpenOrderId = getOpenOrderForUserId(order.getUserId());
        if (existingOpenOrderId != null) {
            throw new IllegalStateException("The user already has an open order in TEMP status");
        }
        Long orderId = orderRepository.createOrder(order);
        return orderId;
    }


    @Override
    public void updateOrderById(Order orderDto) {
        orderRepository.updateOrderById(orderDto);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteOrderById(orderId);

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<OrderItemResponse> getOrderListByUserId(Long userId) throws Exception {
        if (userId != null){
            CustomUser customUser = userService.getCustomUserById(userId);
            if (customUser != null){
                List<OrderItemResponse> orderListsToResponse = new ArrayList<>();
                List<Order> orders = orderRepository.getClosedOrderByUserId(userId);
                if (orders != null && !orders.isEmpty()){
                    for (int i = 0 ; i < orders.size(); i ++){
                        OrderItemResponse userOrderList = new OrderItemResponse();
                        userOrderList.setOrder(orders.get(i));
                        userOrderList.setItems(orderItemService.getAllOrderItemsByOrderId(userOrderList.getOrder().getId()));
                        orderListsToResponse.add(userOrderList);
                    }
                    return orderListsToResponse;
                }else {
                    return orderListsToResponse;
                }
            }else {
                throw new Exception("customer with this id not exist");
            }
        }else {
            throw new Exception("no customer id");
        }    }

    @Override
    public Long getOpenOrderForUserId(Long userId) {
        return orderRepository.getOpenOrderForUserId(userId);
    }

    @Override
    public List<Order> getClosedOrderByUserId(Long userId) {
        return orderRepository.getClosedOrderByUserId(userId);

    }

    @Override
    public void processPayment(Long orderId) {
        Order order = orderRepository.getOrderById(orderId);
        order.setStatus(OrderStatus.CLOSE);
        orderRepository.updateOrderById(order);
    }

    @Override
    public void handleOutOfStockItem(Item existingItem) {
        if (existingItem != null) {
            if (existingItem.getAvailableStock() == 0) {
                // אם כמות המלאי ירדה ל-0, ניתן להוסיף פעולות נוספות כגון שליחת הודעה או יצירת לוג
                System.out.println("Item with id " + existingItem.getId() + " is out of stock.");
            }
        } else {
            throw new IllegalArgumentException("Existing item is null");
        }
    }

    @Override
    public Double calculateTotalPrice(Order order) {
        return calculateTotalPrice(order);
    }

    @Override
    public List<OrderDto> getOrderListsByUserId(Long userId) throws Exception {
        if (userId != null){
            CustomUser customUser = userService.getCustomUserById(userId);
            if (customUser != null){
                List<OrderDto> orderListsToResponse = new ArrayList<>();
                List<Order> orders = orderRepository.getClosedOrderByUserId(userId);
                if (orders != null && !orders.isEmpty()){
                    for (int i = 0 ; i < orders.size(); i ++){
                        OrderDto userOrderList = new OrderDto();
                        userOrderList.setOrder(orders.get(i));
                        userOrderList.setItem(orderItemService.getAllOrderItemsByUserId(userOrderList.getOrder().getId()));
                        orderListsToResponse.add(userOrderList);
                    }
                }
                return orderListsToResponse;
            }else {
                throw new Exception("customer with this id not exist");
            }
        }else {
            throw new Exception("no customer id");
        }
    }
}


