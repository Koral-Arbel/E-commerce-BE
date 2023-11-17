package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser) throws Exception;
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long id, CustomUser customUser);
    void deleteCustomUserById(Long id);

    boolean findUserByUsername(String username);
    boolean findUserByEmail(String email);
}
