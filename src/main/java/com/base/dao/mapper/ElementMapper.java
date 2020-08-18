package com.base.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.dao.entity.Element;

import tk.mybatis.mapper.common.Mapper;

public interface ElementMapper extends Mapper<Element> {
	public List<Element> selectAuthorityElementByUserId(@Param("userId")String userId);
    public List<Element> selectAuthorityMenuElementByUserId(@Param("userId")String userId,@Param("menuId")String menuId);
    public List<Element> selectAuthorityElementByClientId(@Param("clientId")String clientId);
    public List<Element> selectAllElementPermissions();
}