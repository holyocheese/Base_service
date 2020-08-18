package com.base.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.dao.entity.Menu;

import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> selectMenuByAuthorityId(@Param("authorityId") String authorityId,@Param("authorityType") String authorityType);

    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     * @param userId
     * @return
     */
    public List<Menu> selectAuthorityMenuByUserId (@Param("userId") int userId);

    /**
     * 根据用户和组的权限关系查找用户可访问的系统
     * @param userId
     * @return
     */
    public List<Menu> selectAuthoritySystemByUserId (@Param("userId") int userId);
}