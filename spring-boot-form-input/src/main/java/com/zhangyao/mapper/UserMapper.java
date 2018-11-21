package com.zhangyao.mapper;

import java.util.List;

import com.zhangyao.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> selectAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}