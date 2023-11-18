package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(CustomUser customUser) {
        String email = customUser.getEmail();
        if (userRepository.findUserByEmail(email) != null) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        CustomUser user = new CustomUser(
                null,
                customUser.getFirstName(),
                customUser.getLastName(),
                email,
                customUser.getPhone(),
                customUser.getFullAddress(),
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.getRoles(),
                customUser.getPermissions()
        );
        return userRepository.createUser(customUser);
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
        userRepository.updateCustomUserById(userId, customUser);
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
}
