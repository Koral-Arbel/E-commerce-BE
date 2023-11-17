package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CustomUser customUser) throws Exception {
        String email = customUser.getEmail();
        if (userRepository.findUserByEmail(email) == false) {
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
      userRepository.createUser(customUser);
    }

    @Override
    public CustomUser getCustomUserById(Long id) {
        return null;
    }

    @Override
    public void updateCustomUserById(Long id, CustomUser customUser) {

    }

    @Override
    public void deleteCustomUserById(Long id) {

    }

    @Override
    public boolean findUserByUsername(String username) {
            return userRepository.findUserByUsername(username);
        }

    @Override
    public CustomUser findUserByEmail(String email) {
        return null;
    }
}
