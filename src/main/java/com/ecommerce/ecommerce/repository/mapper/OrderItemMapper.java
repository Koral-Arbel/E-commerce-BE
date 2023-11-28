package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class OrderItemMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("order_id"),
                rs.getLong("item_id"),
                rs.getDouble("price"),
                rs.getInt("quantity")
        );
        return orderItem;
    }
}
