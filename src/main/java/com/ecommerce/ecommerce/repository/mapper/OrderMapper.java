package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getTimestamp("order_date").toLocalDateTime(),
                rs.getString("shipping_address"),
                rs.getDouble("total_price"),
                OrderStatus.valueOf(rs.getString("status")));
        return order;
    }
}
