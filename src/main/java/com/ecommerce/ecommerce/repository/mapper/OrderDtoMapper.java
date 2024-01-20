package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.ItemDto;
import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.OrderDto;
import com.ecommerce.ecommerce.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class OrderDtoMapper implements RowMapper<OrderDto> {
    @Override
    public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("order_id"));
        order.setUserId(rs.getLong("user_id"));
        order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
        order.setShippingAddress(rs.getString("shipping_address"));
        order.setStatus(OrderStatus.valueOf(rs.getString("status")));

        ItemDto item = new ItemDto();
        item.setId(rs.getLong("item_id"));
        item.setTitle(rs.getString("title"));
        item.setPhoto(rs.getString("photo"));
        item.setPrice(rs.getDouble("price"));
        item.setAvailableStock(rs.getInt("available_stock"));

        OrderDto orderDto = new OrderDto(order,  Arrays.asList(item));

        return orderDto;
    }
}
