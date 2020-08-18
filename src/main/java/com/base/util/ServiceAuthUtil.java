package com.base.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.base.common.exception.ClientTokenException;
import com.base.model.authen.IJWTInfo;
import com.base.model.authen.ServiceAuthConfig;
import com.base.service.AuthClientService;

import groovy.util.logging.Slf4j;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthUtil {

	@Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private AuthClientService serviceAuthFeign;

    private List<String> allowedClient;
    private String clientToken;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Client token expired!");
        } catch (SignatureException ex) {
            throw new ClientTokenException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Client token is null or empty!");
        }
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient() {
    	this.allowedClient = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken() throws Exception {
    	this.clientToken  = serviceAuthFeign.apply(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
    }


    public String getClientToken() throws Exception {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }
}
