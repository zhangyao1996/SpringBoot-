package com.zhangyao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.UserRole;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}