package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomUserRequest;
import com.ecommerce.ecommerce.model.CustomUserResponse;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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
    public void deleteCustomUserById(Long id) {
        deleteCustomUserById(id);
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
    public CustomUserResponse getCustomerProfile(String username) throws Exception {
        CustomUser curCustomer = userRepository.findUserByUsername(username);
        CustomUserResponse existCustomerProfile = new CustomUserResponse();
        return existCustomerProfile;

    }
}
