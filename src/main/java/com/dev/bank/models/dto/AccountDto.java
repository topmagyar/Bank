package com.dev.bank.models.dto;

import com.dev.bank.util.AccountType;

public class AccountDto {

    private Integer id;
    private String number;
    private Double balance;
    private AccountType type;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
