package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomUserResponse;

public interface UserService {
    void createUser(CustomUser customUser) throws Exception;
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long userId, CustomUser customUser);
    void deleteCustomUserById(Long id);

    CustomUser findUserByUsername(String username);
    CustomUser findUserByEmail(String email);
    CustomUserResponse getCustomerProfile(String username) throws Exception;

}
