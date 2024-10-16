package com.dev.bank.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private Algorithm tokenGenerator;
    private JWTVerifier tokenVerifier;
    public TokenService(@Value("token.secret.password") String keyPassword) {
        this.tokenGenerator = Algorithm.HMAC256(keyPassword);
        this.tokenVerifier = JWT.require(tokenGenerator).withIssuer("BankAPIApplication").build();
    }

    public String generateToken(Integer userId) {
        JWTCreator.Builder tokenBuilder = JWT.create()
                .withIssuer("BankAPIApplication")
                .withClaim("userId", userId)
                .withIssuedAt(new Date());

        String token = tokenBuilder.sign(this.tokenGenerator);

        return token;
    }

    public boolean isTokenValid(String token) {
        if (token == null) {
            return false;
        }

        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = tokenVerifier.verify(token);
        } catch (JWTVerificationException e) {
            System.out.println("TOKEN VERIFICATION EXCEPTION: " + e.getMessage());

            return false;
        }


        if (decodedJWT == null) {
            return false;
        }

        String issuer = decodedJWT.getIssuer();
        Integer userId = decodedJWT.getClaim("userId").asInt();

        if (StringUtils.isNullOrEmpty(issuer) || userId == null) {
            return false;
        }

        return true;
    }
}
