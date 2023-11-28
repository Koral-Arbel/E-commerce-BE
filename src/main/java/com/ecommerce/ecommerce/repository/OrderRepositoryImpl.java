package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private static final String ORDER_TABLE_NAME = "orders";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " " + " (user_id, order_date, shipping_address, total_price, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getOrderDate(), order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

    }

    @Override
    public void updateOrderById(Order order) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET user_id=?, order_date=?, shipping_address=?, total_price=?, status=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql,
                order.getUserId(),
                order.getOrderDate(),
                order.getShippingAddress(),
                order.getTotalPrice(),
                order.getStatus().name(),
                order.getId());
    }

    @Override
    public void deleteOrderById(Long id) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Order getOrderById(Long id) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public Order getOrderByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), userId);
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public Order getOpenOrderForUser(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id = ? AND status = 'TEMP'";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
            return null; // אם אין הזמנה פתוחה, יוחזר null
        }
    }
}
