package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.CustomUser;
import com.ecommerce.ecommerce.model.CustomUserResponse;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @CrossOrigin
    public Long createCustomUser(@RequestBody CustomUser customUser) throws Exception {
       return userService.createUser(customUser);
    }

    @PutMapping("/{userId}/update")
    public void updateCustomUser(@PathVariable Long userId, @RequestBody CustomUser customUser){
        userService.updateCustomUserById(userId, customUser);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteCustomUser(@PathVariable Long userId) {
        userService.deleteCustomUserById(userId);
    }

    @GetMapping("/getUser/{userId}")
    public CustomUserResponse getCustomUserById(@PathVariable Long userId){
        CustomUser customUser = userService.getCustomUserById(userId);

        // יצירת קטע תגובה רק עם המידע הרלוונטי
        CustomUserResponse response = new CustomUserResponse();
        response.setId(customUser.getId());
        response.setFirstName(customUser.getFirstName());
        response.setLastName(customUser.getLastName());
        response.setEmail(customUser.getEmail());

        return response;
    }

    @GetMapping("/getUserByEmail/{email}")
    public CustomUser getCustomUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/getCustomUserByUsername/{username}")
    public CustomUser getCustomUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
}

