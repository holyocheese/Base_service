package com.base.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import com.base.config.KeyConfiguration;
import com.base.model.authen.ServiceAuthConfig;
import com.base.model.authen.UserAuthConfig;
import com.base.service.AuthClientService;

@Configuration
public class AuthClientRunner implements CommandLineRunner {
	private static final Logger log= LoggerFactory.getLogger(AuthClientRunner.class);

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private AuthClientService authClientService;
    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
        try {
       //     refreshUserPubKey();
        }catch(Exception e){
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
        }
        log.info("初始化加载客户pubKey");
        try {
        //    refreshServicePubKey();
        }catch(Exception e){
            log.error("初始化加载客户pubKey失败,1分钟后自动重试!",e);
        }
    }
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey() throws Exception{
    	authClientService.validate(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
    	this.userAuthConfig.setPubKeyByte(keyConfiguration.getUserPubKey()); 
    }
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshServicePubKey() throws Exception{
    	authClientService.validate(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        this.serviceAuthConfig.setPubKeyByte(keyConfiguration.getServicePubKey());
    }

}