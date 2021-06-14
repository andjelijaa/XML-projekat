package com.example.Autentikacija.Security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenBasedAuth extends AbstractAuthenticationToken {

    private String token;
    private final UserDetails principle;


    public TokenBasedAuth(UserDetails details) {
        super(details.getAuthorities());
        this.principle = details;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principle;
    }
}
