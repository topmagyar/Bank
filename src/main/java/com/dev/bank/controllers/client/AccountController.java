package com.dev.bank.controllers.client;

import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.security.TokenValidationRequired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
public interface AccountController {

    @PostMapping("/create") //POST http://localhost:8080/account/create
    @TokenValidationRequired
    CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request);

    @GetMapping("/get/user/{userId}") //GET http://localhost:8080/account/get/user/123
    @TokenValidationRequired
    UserAccountsResponse getUserAccounts(@PathVariable("userId") Integer userId);
}
