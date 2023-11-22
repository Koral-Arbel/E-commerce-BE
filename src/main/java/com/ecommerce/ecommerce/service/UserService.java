package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;

public interface UserService {
    Long createUser(CustomUser customUser);
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long userId, CustomUser customUser);
    void deleteCustomUserById(Long id);

    CustomUser findUserByUsername(String username);
    CustomUser findUserByEmail(String email);

}
