package com.base.base.biz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.base.common.BaseBiz;
import com.base.constant.UserConstant;
import com.base.dao.entity.User;
import com.base.dao.mapper.UserMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper,User> {
    
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity) {
    	String password = entity.getPassword();
		if (StringUtils.isNotEmpty(password)) {
			password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(password);
			entity.setPassword(password);
		}
       
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }
    
    /**
     * 根据用户ID获取用户信息
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUserId(Integer id){
        return mapper.selectByPrimaryKey(id);
    }


}
