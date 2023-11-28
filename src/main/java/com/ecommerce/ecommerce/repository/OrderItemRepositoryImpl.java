package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.OrderItem;
import com.ecommerce.ecommerce.repository.mapper.OrderItemMapper;
import com.ecommerce.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
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
        String sql = "INSERT INTO " + ORDER_ITEM_TABLE_NAME  + " (user_id, order_id, item_id, price, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderItem.getUserId(), orderItem.getOrderId() , orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateCreateOrderItemById(Long orderId, OrderItem orderItem) {
        String sql = "UPDATE " + ORDER_ITEM_TABLE_NAME + " SET user_id=?, order_id=?, item_id=?, price=?, quantity=? " + " WHERE id=?";
        jdbcTemplate.update(sql, orderItem.getUserId(), orderItem.getOrderId(), orderItem.getItemId(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getId());
    }
    @Override
    public OrderItem getOrderItemById(Long id) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderItemMapper(), id);
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public void deleteOrderItemById(Long id) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<OrderItem> getAllItemsByOrderId(Long id) {
        OrderItemMapper orderItemMapper = new OrderItemMapper();
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.query(sql, orderItemMapper, id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return Collections.emptyList(); // או אחרת טפל בשגיאה בדרך שמתאימה לדרישות העסקיות

        }
    }
}
