package com.dev.bank.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenValidationInterceptor implements HandlerInterceptor {

    private static final String SECURITY_TOKEN_HEADER_NAME = "AuthToken";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (handlerMethod.hasMethodAnnotation(TokenValidationRequired.class)) {
                String token = request.getHeader(SECURITY_TOKEN_HEADER_NAME);
                if (token != null) {
                    return true;
                }

                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Invalid token. Please, try to refresh the token");
                response.getWriter().flush();

                return false;
            }
        }

        return true;
    }
}
