package com.dev.bank.models.response;

import com.dev.bank.models.common.BaseResponse;
import com.dev.bank.models.dto.UserDto;

public class UserResponse extends BaseResponse {

    private UserDto user;

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }
}
