package com.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.base.common.exception.UserTokenException;
import com.base.model.authen.JWTInfo;
import com.base.model.authen.UserAuthConfig;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Configuration
public class UserAuthUtil {
	private static final Logger log= LoggerFactory.getLogger(UserAuthUtil.class);
    @Autowired
    private UserAuthConfig userAuthConfig;
    public JWTInfo getInfoFromToken(String token) throws Exception {
        try {
        	log.info("---------------"+userAuthConfig.getPubKeyByte().toString());
            return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
        }catch (ExpiredJwtException ex){
            throw new UserTokenException("User token expired!");
        }catch (SignatureException ex){
            throw new UserTokenException("User token signature error!");
        }catch (IllegalArgumentException ex){
            throw new UserTokenException("User token is null or empty!");
        }
    }
}
