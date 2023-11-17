package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;

public interface UserService {
    void createUser(CustomUser customUser) throws Exception;
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long id, CustomUser customUser);
    void deleteCustomUserById(Long id);

    boolean findUserByUsername(String username);
    CustomUser findUserByEmail(String email);
}
