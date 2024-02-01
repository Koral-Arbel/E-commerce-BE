package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long id, CustomUser customUser);
    void deleteCustomUserById(Long id) throws Exception;

    CustomUser findUserByUsername(String username);
    CustomUser findUserByEmail(String email);
}
