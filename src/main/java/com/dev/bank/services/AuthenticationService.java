package com.dev.bank.services;

import com.dev.bank.dao.UserDao;
import com.dev.bank.models.dao.User;
import com.dev.bank.models.request.AuthLoginRequest;
import com.dev.bank.models.request.AuthRegisterRequest;
import com.dev.bank.models.response.AuthLoginResponse;
import com.dev.bank.models.response.AuthRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.time.ZonedDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthLoginResponse login(AuthLoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (email == null || email.isEmpty()) {
            AuthLoginResponse response = new AuthLoginResponse();
            response.setSuccess(false);
            response.setMessage("Email field is required");

            return response;
        }

        if (password == null || password.isEmpty()) {
            AuthLoginResponse response = new AuthLoginResponse();
            response.setSuccess(false);
            response.setMessage("Your password can't be null or empty");

            return response;
        }

        User user = userDao.getUserByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            AuthLoginResponse response = new AuthLoginResponse();

            response.setSuccess(false);
            response.setMessage("Wrong credentials");

            return response;
        }

        AuthLoginResponse response = new AuthLoginResponse();
        response.setSuccess(true);
        response.setUserId(user.getId());

        return response;
    }

    public AuthRegisterResponse register(AuthRegisterRequest request) {
        ZonedDateTime birthdayDate = request.getBirthday();

        if (!isValidAge(birthdayDate)) {
            AuthRegisterResponse response = new AuthRegisterResponse();

            response.setSuccess(false);
            response.setMessage("Unfortunately, we're not able to register your account as you're under 18");

            return response;
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAge(calculateAge(request.getBirthday()));
        newUser.setPhoneNumber(request.getPhoneNumber());

        Integer newUserId = userDao.saveUser(newUser);

        if (newUserId == null || newUserId == 0) {
            AuthRegisterResponse response = new AuthRegisterResponse();
            response.setSuccess(false);
            response.setMessage("Something went wrong and we're not able to register user");

            return response;
        }

        AuthRegisterResponse response = new AuthRegisterResponse();

        response.setSuccess(true);
        response.setUserId(newUserId);

        return response;
    }

    private Integer calculateAge(ZonedDateTime birthdayDate) {
        Period period = Period.between(birthdayDate.toLocalDate(), ZonedDateTime.now().toLocalDate());

        return period.getYears();
    }

    private boolean isValidAge(ZonedDateTime birthdayDate) {
        if (birthdayDate == null) {
            return false;
        }

        Integer age = calculateAge(birthdayDate);

        return age >= 18;
    }
}
