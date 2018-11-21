package com.zhangyao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.RoleFunction;

@Mapper
public interface RoleFunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleFunction record);

    int insertSelective(RoleFunction record);

    RoleFunction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleFunction record);

    int updateByPrimaryKey(RoleFunction record);
}