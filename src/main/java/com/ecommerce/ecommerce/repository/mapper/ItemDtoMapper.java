package com.ecommerce.ecommerce.repository.mapper;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.model.ItemDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDtoMapper implements RowMapper<ItemDto> {
    @Override
    public ItemDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ItemDto(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("photo"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("available_stock"),
                rs.getLong("serial"));

    }
}
