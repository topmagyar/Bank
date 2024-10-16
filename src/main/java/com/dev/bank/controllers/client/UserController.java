package com.dev.bank.controllers.client;

import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import com.dev.bank.security.TokenValidationRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {

    @GetMapping("/get/all") //http://localhost:8080/user/get/all
    @TokenValidationRequired
    AllUsersResponse getAllUsers();

    @GetMapping("/get/{userId}")//http://localhost:8080/user/get/15
    @TokenValidationRequired
    UserResponse getUserById(@PathVariable("userId") Integer userId);
}
