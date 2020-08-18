package com.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.base.common.exception.UserInvalidException;
import com.base.model.request.JwtAuthenticationRequest;
import com.base.model.response.ObjectRestResponse;
import com.base.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("jwt")
@Api(value="获取token相关接口",tags={"获取接口权限token相关接口"})
public class AuthenController {
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "token", method = RequestMethod.POST)
	@ApiOperation(value = "用户名密码获取token", notes = "用户名密码获取token 有效时间4小时\n "
			+ "请求头增加 Authorization: token 来获取访问其他接口的权限")
    public ObjectRestResponse<String> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        try{
        	final String token = authService.login(authenticationRequest);
        	return new ObjectRestResponse<>().data(token);
        }catch (UserInvalidException e) {
        	ObjectRestResponse<String> res = new ObjectRestResponse<String>();
        	res.setMessage("用户名密码错误");
        	res.setStatus(400);
        	return res;
		}catch (Exception e) {
        	ObjectRestResponse<String> res = new ObjectRestResponse<String>();
        	res.setMessage("服务器出错");
        	res.setStatus(500);
        	return res;
		}
    }
}
