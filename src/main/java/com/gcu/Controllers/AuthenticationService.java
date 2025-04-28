package com.gcu.Controllers;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements Authentication
{
    @Override
    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }
}
