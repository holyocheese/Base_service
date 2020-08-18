package com.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.base.base.biz.UserBiz;
import com.base.common.exception.UserInvalidException;
import com.base.model.authen.JWTInfo;
import com.base.model.request.JwtAuthenticationRequest;
import com.base.model.vo.UserInfo;
import com.base.service.AuthService;
import com.base.service.PermissionService;
import com.base.util.JwtTokenUtil;

@Service
public class AuthServiceImpl implements AuthService{
	
	private JwtTokenUtil jwtTokenUtil;
    private UserBiz userService;
	@Autowired
    private PermissionService permissionService;
    
    
    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            UserBiz userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        UserInfo info = permissionService.validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName(),info.getTenantId()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    }

}
