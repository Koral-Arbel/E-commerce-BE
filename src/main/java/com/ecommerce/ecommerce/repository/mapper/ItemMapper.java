package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("photo"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("available_stock"));
    }
}
