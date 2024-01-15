package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.TestResponse;
import com.ecommerce.ecommerce.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public")
public class PublicRestApiController {
    @Autowired
    private JwtUtil jwtUtil;
    @CrossOrigin
    @GetMapping(value = "/test1")
    public ResponseEntity<?> test1(@RequestParam(value = "Authorization")String token){
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        System.out.println(username);
        return ResponseEntity.ok(new TestResponse("API test 1"));
    }

    @CrossOrigin
    @GetMapping(value = "/test2")
    public ResponseEntity<?> test2(){
        return ResponseEntity.ok(new TestResponse("API Test 2"));
    }
}
