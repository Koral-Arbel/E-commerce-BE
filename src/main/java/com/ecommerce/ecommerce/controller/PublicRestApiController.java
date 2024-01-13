package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.TestResponse;
import com.ecommerce.ecommerce.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/public")
public class PublicRestApiController {
    @Autowired
    private JwtUtil jwtUtil;
    @CrossOrigin
    @GetMapping(value = "/test1")
    public ResponseEntity<?> test1(){
        return ResponseEntity.ok(new TestResponse("API Test 1"));
    }
    @CrossOrigin
    @GetMapping(value = "/test2")
    public ResponseEntity<?> test2(){
        return ResponseEntity.ok(new TestResponse("API Test 2"));
    }
}
