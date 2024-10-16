package com.dev.bank.dao;

import com.dev.bank.models.dao.User;

import java.util.List;

public interface UserDao {

    Integer saveUser(User user);

    User getUserByEmail(String email);
    List<User> findAllUsers();
    User getUserById(Integer id);
}
