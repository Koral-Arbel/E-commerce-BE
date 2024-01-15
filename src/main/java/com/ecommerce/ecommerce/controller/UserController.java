package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomerProfileResponse;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/user")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createUser(@RequestBody CustomUser customUser) throws Exception {
       userService.createUser(customUser);
    }
    @CrossOrigin
    @PutMapping(value = "/{userId}/update")
    public void updateCustomUser(@PathVariable Long userId, @RequestBody CustomUser customUser){
        userService.updateCustomUserById(userId, customUser);
    }
    @CrossOrigin
    @DeleteMapping(value = "/deleteUser/{userId}")
    public void deleteCustomUser(@PathVariable Long userId) throws Exception {
        userService.deleteCustomUserById(userId);
    }
    @CrossOrigin
    @GetMapping(value = "/getUser")
    public CustomUser getCustomUserById(@PathVariable Long userId){
       return userService.getCustomUserById(userId);
    }
    @CrossOrigin
    @GetMapping(value = "/getUserByEmail/{email}")
    public CustomUser getCustomUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @CrossOrigin
    @GetMapping(value = "/findUser/{username}")
    public CustomUser findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
    @CrossOrigin
    @GetMapping(value = "/profile/{username}")
    public CustomerProfileResponse getCustomerProfile(@PathVariable String username) throws Exception {
        return userService.getCustomerProfile(username);
    }
}

