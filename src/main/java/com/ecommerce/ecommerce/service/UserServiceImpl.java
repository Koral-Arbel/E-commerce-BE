package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.*;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FavoriteItemService favoriteItemService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderService orderService;

    @Override
    public void createUser(CustomUser customUser) throws Exception {
        String email = customUser.getEmail();
        if (userRepository.findUserByEmail(email) != null) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        CustomUser existingCustomUser = userRepository.findUserByUsername(customUser.getUsername());
        if (existingCustomUser != null) {
            throw new Exception("Username " + customUser.getUsername() + " is already taken");
        }

        userRepository.createUser(customUser);

    }

    @Override
    public CustomUser getCustomUserById(Long id) {
        return userRepository.getCustomUserById(id);
    }

    @Override
    public void updateCustomUserById(Long userId, CustomUser customUser) {
        if (customUser != null) {
            userRepository.updateCustomUserById(userId, customUser);
        } else {
            System.out.println("Unable to update");
        }
    }

    @Override
    public void deleteCustomUserById(Long id) throws Exception {
        if (id != null){
            CustomUser deleteCustomUser = userRepository.getCustomUserById(id);
            if (deleteCustomUser != null){
                orderItemService.deleteOrderItemsByUserId(id);
                orderService.deleteOrdersByUserId(id);
                favoriteItemService.deleteAllItemFromFavoriteByUserId(id);
                userRepository.deleteCustomUserById(id);
            }else{
                throw new Exception("No such customer with this id " + id);
            }
        }else {
            throw new Exception("Id is null");
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public CustomUser findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public CustomerProfileResponse getCustomerProfile(String username) throws Exception {
        CustomUser customUser = userRepository.findUserByUsername(username);
        List<Item> userFavoriteItems = favoriteItemService.getFavoriteItemsByUserId(customUser.getId());
        List<ItemDto> userOrderItems = orderItemService.getAllOrderItemsByUserId(customUser.getId());
        List<OrderItemResponse> userOrderItemList = orderService.getOrderListByUserId(customUser.getId());

        CustomerProfileResponse existUserProfile = new CustomerProfileResponse(
                customUser,
                userFavoriteItems,
                userOrderItems,
                userOrderItemList
        );
        return existUserProfile;
    }
}