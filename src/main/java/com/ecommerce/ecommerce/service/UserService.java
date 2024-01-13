package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomerProfileResponse;

public interface UserService {
    void createUser(CustomUser customUser) throws Exception;
    CustomUser getCustomUserById(Long id);
    void updateCustomUserById(Long userId, CustomUser customUser);
    void deleteCustomUserById(Long id) throws Exception;

    CustomUser findUserByUsername(String username);
    CustomUser findUserByEmail(String email);
    CustomerProfileResponse getCustomerProfile(String username) throws Exception;

}
