package com.dev.bank.controllers;

import com.dev.bank.controllers.client.UserController;
import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import com.dev.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService service;

    @Override
    public AllUsersResponse getAllUsers() {
        return service.getAllUsers();
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        return service.getUserById(userId);
    }
}
