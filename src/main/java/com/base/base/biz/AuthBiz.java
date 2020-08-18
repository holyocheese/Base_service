package com.base.base.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.entity.Client;
import com.base.dao.mapper.ClientMapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class AuthBiz extends BaseBiz<ClientMapper,Client> {
	
}
