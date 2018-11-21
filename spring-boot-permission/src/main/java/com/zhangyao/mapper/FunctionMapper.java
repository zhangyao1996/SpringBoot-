package com.zhangyao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.Function;

@Mapper
public interface FunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}