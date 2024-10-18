package com.dev.bank.services;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.Account;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.dto.AccountDto;
import com.dev.bank.models.dto.UserDto;
import com.dev.bank.models.response.AllUsersResponse;
import com.dev.bank.models.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public AllUsersResponse getAllUsers() {
        List<User> users = userDao.findAllUsers();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            UserDto dto = new UserDto();

            dto.setUserId(user.getId());
            dto.setAge(user.getAge());
            dto.setEmail(user.getEmail());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setPhoneNumber(user.getPhoneNumber());

            userDtoList.add(dto);
        }

        AllUsersResponse response = new AllUsersResponse();

        response.setSuccess(true);
        response.setUsers(userDtoList);

        return response;
    }

    public UserResponse getUserById(Integer userId) {
        if (userId == null) {
            UserResponse response = new UserResponse();

            response.setSuccess(false);
            response.setMessage("User id couldn't be null");

            return response;
        }

        User user = userDao.getUserById(userId);

        if (user.getId() == -1) {
            UserResponse response = new UserResponse();

            response.setSuccess(false);
            response.setMessage("User with id '" + userId + "' could not be found");

            return response;
        }

        UserDto dto = new UserDto();
        dto.setUserId(user.getId());
        dto.setAge(user.getAge());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhoneNumber(user.getPhoneNumber());

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

        dto.setAccounts(accountDtoList);

        UserResponse response = new UserResponse();

        response.setSuccess(true);
        response.setUser(dto);

        return response;
    }
}
