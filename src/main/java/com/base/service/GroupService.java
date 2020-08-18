package com.base.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.entity.Group;
import com.base.dao.mapper.GroupMapper;


@Service
public class GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	//查询userId的用户角色数据 第一条作为群主角色 第二条作为群员角色
	public List<String> selectUserGroup(Integer userId){
		List<String> result = new ArrayList<String>();
		List<Group> groupLeaderList = groupMapper.selectGroupListByUserLeader(userId);
		List<Group> groupMemberList = groupMapper.selectGroupListByUserMember(userId);
		String leadstr = "";
		for(Group leadGr:groupLeaderList){
			leadstr += leadGr.getName() + ",";
		}
		if(leadstr.length()>1){
			leadstr = leadstr.substring(0, leadstr.length()-1);
		}
		result.add(leadstr);
		String memberstr = "";
		for(Group memberGr:groupMemberList){
			memberstr += memberGr.getName() + ",";
		}
		if(memberstr.length()>1){
			memberstr = memberstr.substring(0, memberstr.length()-1);
		}
		result.add(memberstr);
		return result;
	}
}
