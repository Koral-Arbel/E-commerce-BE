package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String USER_TABLE_NAME = "custom_user";
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
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
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
