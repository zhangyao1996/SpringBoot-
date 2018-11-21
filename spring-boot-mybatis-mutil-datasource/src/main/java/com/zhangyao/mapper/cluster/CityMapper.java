package com.zhangyao.mapper.cluster;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.City;

@Mapper
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}