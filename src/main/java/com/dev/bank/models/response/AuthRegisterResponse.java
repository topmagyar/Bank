package com.dev.bank.models.response;

import com.dev.bank.models.common.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

public class AuthRegisterResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
