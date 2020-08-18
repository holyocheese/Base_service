package com.base.dao.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Value("${jwt.token-header}")
    private String userTokenHeader;

	public String getUserTokenHeader() {
		return userTokenHeader;
	}

	public void setUserTokenHeader(String userTokenHeader) {
		this.userTokenHeader = userTokenHeader;
	}
    
    
}
