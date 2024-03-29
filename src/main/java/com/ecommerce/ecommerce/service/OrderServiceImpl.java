package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.ItemRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
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
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<OrderItemResponse> getOrderListByUserId(Long userId) {
        List<OrderItemResponse> orderListsToResponse = new ArrayList<>();
        List<Order> openOrders = orderRepository.getOrdersByStatus(userId, OrderStatus.TEMP);
        if (openOrders != null && !openOrders.isEmpty()) {
            for (Order openOrder : openOrders) {
                OrderItemResponse userOrderList = new OrderItemResponse();
                userOrderList.setOrder(openOrder);
                userOrderList.setItems(orderItemService.getAllOrderItemsByOrderId(userOrderList.getOrder().getId()));
                orderListsToResponse.add(userOrderList);
            }
        }

        return orderListsToResponse;
    }

    @Override
    public Long getOpenOrderForUserId(Long userId) {
        return orderRepository.getOpenOrderForUserId(userId);
    }

    @Override
    public List<OrderDto> getClosedOrderByUserId(Long userId) throws Exception {
        List<OrderDto> orderListsToResponse = new ArrayList<>();
        List<Order> closedOrders = orderRepository.getOrdersByStatus(userId, OrderStatus.CLOSE);
        if (closedOrders != null && !closedOrders.isEmpty()) {
            for (Order closedOrder : closedOrders) {
                OrderDto userOrderList = new OrderDto();
                userOrderList.setOrder(closedOrder);
                userOrderList.setItem(orderItemService.getAllOrderItemsByUserId(userOrderList.getOrder().getId()));
                orderListsToResponse.add(userOrderList);
            }
        }
        return orderListsToResponse;
    }

    @Override
    public void processPayment(Long orderId) {
        Order order = orderRepository.getOrderById(orderId);
        if (order.getStatus() == OrderStatus.TEMP) {
            List<OrderItem> orderItems = orderItemService.getAllItemsByOrderId(orderId);
            for (OrderItem orderItem : orderItems) {
                Item item = itemRepository.getItemById(orderItem.getItemId());
                int orderedQuantity = orderItem.getQuantity();
                if (item.getAvailableStock() >= orderedQuantity) {
                    int updatedStock = item.getAvailableStock() - orderedQuantity;
                    itemRepository.updateAvailableStock(item.getId(), updatedStock);
                } else {
                    System.out.println("Error: Insufficient stock for item with id " + item.getId());
                }
            }
            order.setStatus(OrderStatus.CLOSE);
            orderRepository.updateOrderById(order);
        } else {
            System.out.println("Error: Trying to process payment for an order that is not in TEMP status.");
        }
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) {
        return orderRepository.getAllOrdersByUserId(userId);
    }
    @Override
    public List<Order> getAllItemsByStatus(Long userId, OrderStatus status) {

        return orderRepository.getOrdersByStatus(userId, status);
    }

    @Override
    public void handleOutOfStockItem(Item existingItem) {
        if (existingItem != null) {
            if (existingItem.getAvailableStock() == 0) {
                System.out.println("Item with id " + existingItem.getId() + " is out of stock.");
            }
        } else {
            throw new IllegalArgumentException("Existing item is null");
        }
    }

    @Override
    public List<OrderDto> getOrderListsByUserId(Long userId) throws Exception {
        if (userId != null){
            CustomUser customUser = userService.getCustomUserById(userId);
            if (customUser != null){
                List<OrderDto> orderListsToResponse = new ArrayList<>();
                List<Order> orders = orderRepository.getOrdersByStatus(userId, OrderStatus.CLOSE);
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

    @Override
    public void deleteOrdersByUserId(Long id, Long userId) {
        orderRepository.deleteOrdersByUserId(id, userId);
    }
}


