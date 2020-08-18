package com.base.base.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.common.BaseBiz;
import com.base.dao.entity.ResourceAuthority;
import com.base.dao.mapper.ResourceAuthorityMapper;
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
