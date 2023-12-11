package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomUserResponse;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @CrossOrigin
    public void createUser(@RequestBody CustomUser customUser) throws Exception {
       userService.createUser(customUser);
    }

    @PutMapping("/{userId}/update")
    @CrossOrigin
    public void updateCustomUser(@PathVariable Long userId, @RequestBody CustomUser customUser){
        userService.updateCustomUserById(userId, customUser);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @CrossOrigin
    public void deleteCustomUser(@PathVariable Long userId) {
        userService.deleteCustomUserById(userId);
    }

    @GetMapping("/getUser/{userId}")
    @CrossOrigin
    public CustomUser getCustomUserById(@PathVariable Long userId){
       return userService.getCustomUserById(userId);
    }

    @GetMapping("/getUserByEmail/{email}")
    @CrossOrigin
    public CustomUser getCustomUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/username/{username}")
    @CrossOrigin
    public CustomUser getCustomUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping(value = "/profile/{username}")
    @CrossOrigin
    public CustomUserResponse getCustomerProfile(@PathVariable String username) throws Exception {
        return userService.getCustomerProfile(username);
    }
}

