package com.base.service;

import com.base.model.request.JwtAuthenticationRequest;

public interface AuthService {

	String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
    String refresh(String oldToken) throws Exception;
    void validate(String token) throws Exception;
}
