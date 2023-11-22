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
    public Item createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title, photo, price, available_stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getTitle(),item.getPhoto(), item.getPrice(), item.getAvailableStock());
        jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        return createItem(item);
    }

    @Override
    public void updateItemById(Item item) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + "SET title=?, photo=?, price=?, available_stock=? WHERE id=?";
        jdbcTemplate.update(
                sql, item.getTitle(), item.getPhoto(), item.getPrice(), item.getAvailableStock(), item.getId());
    }

    @Override
    public void deleteItemById(Long id) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
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
