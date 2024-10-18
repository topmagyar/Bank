package com.dev.bank.models.response;

import com.dev.bank.models.common.BaseResponse;

public class CreateAccountResponse extends BaseResponse {

    private Integer id;
    private String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
