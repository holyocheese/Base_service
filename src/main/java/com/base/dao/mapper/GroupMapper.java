package com.base.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.dao.entity.Group;

import tk.mybatis.mapper.common.Mapper;

public interface GroupMapper extends Mapper<Group> {
	public void deleteGroupMembersById (@Param("groupId") int groupId);
    public void deleteGroupLeadersById (@Param("groupId") int groupId);
    public void insertGroupMembersById (@Param("groupId") int groupId,@Param("userId") int userId);
    public void insertGroupLeadersById (@Param("groupId") int groupId,@Param("userId") int userId);
    public List<Group> selectGroupListByUserMember(@Param("userId") int userId);
    public List<Group> selectGroupListByUserLeader(@Param("userId") int userId);
}