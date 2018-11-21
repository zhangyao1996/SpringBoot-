package com.zhangyao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhangyao.entity.SysUser;

public interface SysUserMapperCustom {
	//@Select("select * from sys_user where id=#{id}")
	List<SysUser> queryUserSimplyInfoById(String id);
	
	
	
}