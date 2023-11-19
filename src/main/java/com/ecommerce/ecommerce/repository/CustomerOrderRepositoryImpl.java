package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomerOrder;
import com.ecommerce.ecommerce.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {
    private static final String CUSTOM_ORDER_TABLE_NAME = "custom_order";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerOrderMapper customerOrderMapper;
    @Override
    public Long createCustomerOrder(CustomerOrder customerOrder) {
        String sql = "INSERT INTO " + CUSTOM_ORDER_TABLE_NAME + " " + "(user_id, order_date, shipping_address, total_price, status) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customerOrder.getUserId(),
                customerOrder.getDate(),
                customerOrder.getShippingAddress(),
                customerOrder.getTotalPrice(),
                customerOrder.getStatus().name()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateCreateCustomerOrderById(Long id, CustomerOrder customerOrder) {
        String sql = "UPDATE " + CUSTOM_ORDER_TABLE_NAME + "SET user_id=?, order_date=?, shipping_address=?, total_price=?, status=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                customerOrder.getUserId(),
                customerOrder.getDate(),
                customerOrder.getShippingAddress(),
                customerOrder.getTotalPrice(),
                customerOrder.getStatus(),
                customerOrder.getId()
        );
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        String sql = "DELETE FROM " + CUSTOM_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOM_ORDER_TABLE_NAME + " WHERE status = ?";
        try {
            return jdbcTemplate.queryForObject(sql, customerOrderMapper, id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getAllCustomerByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOM_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try{
            return jdbcTemplate.query(sql, customerOrderMapper, customerId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Waring");
            return null;
        }
    }
}