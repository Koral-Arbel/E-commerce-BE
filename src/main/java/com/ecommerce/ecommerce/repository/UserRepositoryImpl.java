package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String USER_TABLE_NAME = "custom_user";
    private static final String ORDER_TABLE_NAME = "orders";
    private static final String FAVORITE_ITEM_TABLE_NAME = "favorite_item";
    private static final String ORDER_ITEM_TABLE_NAME = "order_item";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, phone, full_address, username, password, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(), customUser.getPhone(), customUser.getFullAddress(), customUser.getUsername(), customUser.getPassword(), "", "");
    }


    @Override
    public CustomUser getCustomUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }

    @Override
    public void updateCustomUserById(Long userId, CustomUser customUser) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone=?, full_address=?, username=?, password=?, roles=?, permissions=? " + "WHERE id=?";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(), customUser.getPhone(), customUser.getFullAddress(), customUser.getUsername(), customUser.getPassword(), "", "", customUser.getId());
    }

    @Override
    public void deleteCustomUserById(Long id) {
        try {
            // Delete order items associated with the user
            String deleteOrderItemsSql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_id IN (SELECT id FROM " + ORDER_TABLE_NAME + " WHERE user_id=?)";
            jdbcTemplate.update(deleteOrderItemsSql, id);

            // Delete orders associated with the user
            String deleteOrdersSql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE user_id=?";
            jdbcTemplate.update(deleteOrdersSql, id);

            // Delete favorite items associated with the user
            String deleteFavoriteItemsSql = "DELETE FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE user_id=?";
            jdbcTemplate.update(deleteFavoriteItemsSql, id);

            // Delete the user
            String deleteUserSql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
            jdbcTemplate.update(deleteUserSql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public CustomUser findUserByEmail(String email) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE email=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), email);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

}
