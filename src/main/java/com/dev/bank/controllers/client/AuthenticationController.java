package com.dev.bank.controllers.client;

import com.dev.bank.models.request.AuthLoginRequest;
import com.dev.bank.models.request.AuthRegisterRequest;
import com.dev.bank.models.response.AuthLoginResponse;
import com.dev.bank.models.response.AuthRegisterResponse;
import com.dev.bank.security.TokenValidationRequired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticationController {

    @PostMapping("/login") // POST http://localhost:8080/auth/login
    AuthLoginResponse login(@RequestBody AuthLoginRequest request);

    @PostMapping("/register") // POST http://localhost:8080/auth/register
    AuthRegisterResponse register(@RequestBody AuthRegisterRequest request);
}
