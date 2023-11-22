package com.ecommerce.ecommerce.utils;

public class UserNotRegisteredException extends RuntimeException  {
    public UserNotRegisteredException(String message) {
        super(message);
    }
}
