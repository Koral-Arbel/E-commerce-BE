package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.CustomerOrder;
import com.ecommerce.ecommerce.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CustomerOrderMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerOrder customerOrder = new CustomerOrder(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("shipping_address"),
                rs.getDouble("total_price"),
                OrderStatus.valueOf(rs.getString("status"))
        );
        return customerOrder;
    }
}
