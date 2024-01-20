package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderDto;
import com.ecommerce.ecommerce.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final String ORDER_TABLE_NAME = "orders";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " (user_id, order_date, shipping_address, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getOrderDate(), order.getShippingAddress(), order.getStatus().name());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    @Override
    public void updateOrderById(Order order) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET user_id=?, order_date=?, shipping_address=?, status=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql,
                order.getUserId(),
                order.getOrderDate(),
                order.getShippingAddress(),
                order.getStatus().name(),
                order.getId());
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
    public void deleteOrderById(Long id) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public Long getOpenOrderForUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id=? AND status= 'TEMP'";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), userId).getId();
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Order> getClosedOrderByUserId(Long userId) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) {
        String sql = "SELECT o.id AS order_id, o.user_id, o.order_date, o.shipping_address, o.status," +
                "i.id AS item_id, i.title, i.photo, i.price, i.available_stock, oi.quantity " +
                "FROM orders o " +
                "JOIN order_item oi ON o.id = oi.order_id " +
                "JOIN item i ON oi.item_id = i.id " +
                "WHERE o.user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(OrderDto.class));
    }
}
