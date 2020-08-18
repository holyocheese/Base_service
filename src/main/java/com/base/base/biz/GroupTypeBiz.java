package com.base.base.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.entity.GroupType;
import com.base.dao.mapper.GroupTypeMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
