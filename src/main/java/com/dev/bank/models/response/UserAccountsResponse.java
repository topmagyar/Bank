package com.dev.bank.models.response;

import com.dev.bank.models.common.BaseResponse;
import com.dev.bank.models.dto.AccountDto;

import java.util.List;

public class UserAccountsResponse extends BaseResponse {
    private List<AccountDto> accounts;

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }
}
