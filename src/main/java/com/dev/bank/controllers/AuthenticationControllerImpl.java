package com.dev.bank.controllers;

import com.dev.bank.controllers.client.AuthenticationController;
import com.dev.bank.models.request.AuthLoginRequest;
import com.dev.bank.models.request.AuthRegisterRequest;
import com.dev.bank.models.response.AuthLoginResponse;
import com.dev.bank.models.response.AuthRegisterResponse;
import com.dev.bank.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    private AuthenticationService service; //NOT NULL

    @Override
    public AuthLoginResponse login(AuthLoginRequest request) {
        AuthLoginResponse response = service.login(request);

        return response;
    }

    @Override
    public AuthRegisterResponse register(AuthRegisterRequest request) {
        AuthRegisterResponse response = service.register(request);

        return response;
    }
}
