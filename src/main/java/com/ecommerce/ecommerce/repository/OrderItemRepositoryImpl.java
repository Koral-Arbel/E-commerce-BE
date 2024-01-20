package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.mapper.OrderItemMapper;
import com.ecommerce.ecommerce.repository.mapper.OrderMapper;
import com.ecommerce.ecommerce.service.ItemService;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    private static final String ORDER_ITEM_TABLE_NAME = "order_item";
    private static final String ORDER_TABLE_NAME = "orders";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ItemService itemService;
    @Override
    public Long createOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO " + ORDER_ITEM_TABLE_NAME  + " (user_id, order_id, item_id, price, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderItem.getUserId(), orderItem.getOrderId() , orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateOrderItemById(Long orderId, OrderItem orderItem) {
        String sql = "UPDATE " + ORDER_ITEM_TABLE_NAME + " SET user_id=?, order_id=?, item_id=?, price=?, quantity=? " + " WHERE id=?";
        jdbcTemplate.update(sql, orderItem.getUserId(), orderItem.getOrderId(), orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getId());
    }
    @Override
    public OrderItem getOrderItemById(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderItemMapper(), orderId);
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public void deleteOrderItemById(Long itemId) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE item_id=?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public List<OrderItem> getAllItemsByOrderId(Long id) {
        OrderItemMapper orderItemMapper = new OrderItemMapper();
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_id=?";
        try {
            return jdbcTemplate.query(sql, orderItemMapper, id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return Collections.emptyList(); // או אחרת טפל בשגיאה בדרך שמתאימה לדרישות העסקיות

        }
    }

    @Override
    public List<OrderDto> getOrdersByStatus(OrderStatus status) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=?";
        List<Order> orders = jdbcTemplate.query(sql, orderMapper, status.toString());

        return orders.stream()
                .map(order -> {
                    List<ItemDto> itemDtos = itemService.getItemsByOrderId(order.getId())
                            .stream()
                            .map(Item::toItemDto)
                            .collect(Collectors.toList()); // Use toItemDto method of Item class
                    return new OrderDto(order, itemDtos);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void processPayment(Long orderId) {
        String updateQuery = "UPDATE orders SET status = 'CLOSE' WHERE id = ?";
        jdbcTemplate.update(updateQuery, orderId);
    }
}
