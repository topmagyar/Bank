package com.dev.bank.dao.impl;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.User;
import com.dev.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public Integer saveUser(User user) {//ID is null
        User createdUser;
        try {
            createdUser = repository.save(user);
        } catch (Exception e) {
            return 0;
        }

        return createdUser.getId();
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
