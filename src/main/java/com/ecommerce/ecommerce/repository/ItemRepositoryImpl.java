package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private static final String ITEM_TABLE_NAME = "item";
    private static final String ORDER_ITEM_TABLE_NAME = "order_item";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Item createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title, photo, price, available_stock) VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getTitle(), item.getPhoto(), item.getPrice(), item.getAvailableStock());
        Long generatedId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        item.setId(generatedId);
        return item;
    }

    @Override
    public void updateItemById(Item item) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET title=?, photo=?, price=?, available_stock=? WHERE id=?";
        jdbcTemplate.update(
                sql, item.getTitle(), item.getPhoto(), item.getPrice(), item.getAvailableStock(), item.getId());
    }

    @Override
    public void deleteItemById(Long id) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Item getItemById(Long id) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateAvailableStock(Long itemId, Integer availableStock) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET available_stock=? WHERE id=?";
        jdbcTemplate.update(sql, availableStock, itemId);
    }

    @Override
    public List<Item> getItemsByOrderId(Long orderId) {
        String sql = " SELECT i.* FROM " + ORDER_ITEM_TABLE_NAME + " oi JOIN " + ITEM_TABLE_NAME + " i ON oi.item_id = i.id " + " WHERE oi.order_id=?";
        try {
            return jdbcTemplate.query(sql, new ItemMapper(), orderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Item> searchItems(String title) {
        String sql = "SELECT id, title, price, photo FROM item WHERE LOWER(title) LIKE LOWER(?)";
        String likeTerm = "%" + title + "%";

        return jdbcTemplate.query(sql, new Object[]{likeTerm}, new BeanPropertyRowMapper<>(Item.class));
    }
}

