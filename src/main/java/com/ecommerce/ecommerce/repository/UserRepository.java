package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomUserResponse;

public interface UserRepository {
    Long createUser(CustomUser customUser);
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long userId, CustomUser customUser);
    void deleteCustomUserById(Long id);

    CustomUser findUserByUsername(String username);
    CustomUser findUserByEmail(String email);
}
