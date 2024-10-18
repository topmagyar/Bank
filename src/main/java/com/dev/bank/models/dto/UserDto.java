package com.dev.bank.models.dto;

import java.util.List;

public class UserDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String phoneNumber;
    private List<AccountDto> accounts;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }
}
