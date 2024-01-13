package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.mapper.FavoriteItemMapper;
import com.ecommerce.ecommerce.repository.mapper.ItemDtoMapper;
import com.ecommerce.ecommerce.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteItemRepositoryImpl implements FavoriteItemRepository {
    private static final String FAVORITE_ITEM_TABLE_NAME = "favorite_item";
    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createItemAddToFavorites(FavoriteItem favoriteItem) {
        String sql = "INSERT INTO " + FAVORITE_ITEM_TABLE_NAME + " (user_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favoriteItem.getUserId(), favoriteItem.getItemId());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateFavorites(Long id, FavoriteItem favoriteItem) {
        String sql = "UPDATE " + FAVORITE_ITEM_TABLE_NAME + " SET user_id=?, item_id=? WHERE id=?";
        jdbcTemplate.update(sql, favoriteItem.getUserId(), favoriteItem.getItemId(), id);
    }

    @Override
    public FavoriteItem getFavoriteItemListById(Long id) {
        String sql = "SELECT * FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new FavoriteItemMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void removeFromFavorites(Long id) {
        String sql = "DELETE FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteAllItemFromFavoriteByUserId(Long userId) {
        String sql = "DELETE FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);

    }
    @Override
    public List<Item> getFavoriteItemsByUserId(Long userId) {
        String sql = "SELECT " + ITEM_TABLE_NAME + ".*, " + FAVORITE_ITEM_TABLE_NAME + ".id FROM " + ITEM_TABLE_NAME +
                " INNER JOIN " + FAVORITE_ITEM_TABLE_NAME + " ON " + ITEM_TABLE_NAME + ".id = " + FAVORITE_ITEM_TABLE_NAME + ".item_id" +
                " WHERE " + FAVORITE_ITEM_TABLE_NAME + ".user_id=?";
        try {
            return jdbcTemplate.query(sql, new ItemMapper(), userId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}
