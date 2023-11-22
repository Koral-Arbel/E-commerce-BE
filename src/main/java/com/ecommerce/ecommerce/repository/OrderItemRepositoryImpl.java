package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.repository.mapper.OrderItemMapper;
import com.ecommerce.ecommerce.repository.mapper.OrderMapper;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    private static final String ORDER_ITEM_TABLE_NAME = "order_item";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Override
    public Long createOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO " + ORDER_ITEM_TABLE_NAME + " (order_id, item_id, price, quantity, total_price, status) VALUES (?, ?, ?, ?, ?, ?)";
        // Log the values for debugging
        System.out.println("Inserting OrderItem: " + orderItem);
        jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getTotalPrice(), orderItem.getOrderStatus());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    @Override
    public void updateCreateOrderItemById(OrderItem orderItem) {
        String sql = "UPDATE " + ORDER_ITEM_TABLE_NAME + " SET order_id=?, item_id=?,  price=?, quantity=?, total_price=?, status=? " + "WHERE id=?";
        jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getTotalPrice(), orderItem.getOrderStatus(), orderItem.getId());
    }
    @Override
    public OrderItem getOrderItemById(Long id) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE id=?";
        try {
            jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
            return getOrderItemById(id);
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public void deleteOrderItemById(Long id) {
        String sql = "DELETE FROM order_item WHERE order_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<OrderItem> getAllItemsByOrderId(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE user_id=?";
        try{
            return jdbcTemplate.query(sql, orderItemMapper, orderId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Waring");
            return null;
        }
    }
}
