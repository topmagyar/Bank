package com.dev.bank.services;

import com.dev.bank.dao.AccountDao;
import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.dto.AccountDto;
import com.dev.bank.models.request.CreateAccountRequest;
import com.dev.bank.models.response.CreateAccountResponse;
import com.dev.bank.models.response.UserAccountsResponse;
import com.dev.bank.util.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountDao accountDao;

    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Integer userId = request.getUserId();
        AccountType type = request.getType();

        if (userId == null || userId <= 0) {
            CreateAccountResponse response = new CreateAccountResponse();

            response.setSuccess(false);
            response.setMessage("Request should contain valid user id");

            return response;
        }

        if (type == null) {
            CreateAccountResponse response = new CreateAccountResponse();

            response.setSuccess(false);
            response.setMessage("Request should contain valid account type");

            return response;
        }

        User user = userDao.getUserById(userId);

        if (user == null || user.getId() <= 0) {
            CreateAccountResponse response = new CreateAccountResponse();

            response.setSuccess(false);
            response.setMessage("User with id: '" + userId + "' doesn't exist");

            return response;
        }

        Account newAccount = new Account();
        newAccount.setUser(user);
        newAccount.setBalance(0.0);
        newAccount.setType(type);
        newAccount.setNumber("78132978123978312");

        Account createdAccount = accountDao.saveAccount(newAccount);

        CreateAccountResponse response = new CreateAccountResponse();

        response.setSuccess(true);
        response.setId(createdAccount.getId());
        response.setNumber(createdAccount.getNumber());

        return response;
    }

    public UserAccountsResponse getUserAccounts(Integer userId) {
        if (userId == null || userId <= 0) {
            UserAccountsResponse response = new UserAccountsResponse();

            response.setSuccess(false);
            response.setMessage("Request should contain valid user id");

            return response;
        }

        User user = userDao.getUserById(userId);

        if (user == null || user.getId() <= 0) {
            UserAccountsResponse response = new UserAccountsResponse();
            response.setSuccess(false);
            response.setMessage("User with id: '" + userId + "' doesn't exist");

            return response;
        }

        List<Account> accounts = user.getAccounts();
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setNumber(account.getNumber());
            accountDto.setBalance(account.getBalance());
            accountDto.setType(account.getType());

            accountDtoList.add(accountDto);
        }

        UserAccountsResponse response = new UserAccountsResponse();

        response.setSuccess(true);
        response.setAccounts(accountDtoList);

        return response;
    }
}
