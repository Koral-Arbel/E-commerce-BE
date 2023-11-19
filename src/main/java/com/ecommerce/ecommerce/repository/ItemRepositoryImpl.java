package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title, price, photo, available_stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getTitle(), item.getPrice(), item.getPhoto(), item.getAvailableStock());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);

    }

    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
