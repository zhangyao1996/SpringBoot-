package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.City;
import com.zhangyao.entity.User;
import com.zhangyao.mapper.cluster.CityMapper;
import com.zhangyao.mapper.master.UserMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 19, 2018 4:08:09 PM
*/
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	 public User findById(Integer id) {
	        User user = userMapper.selectByPrimaryKey(id);
//	        City city = cityMapper.selectByPrimaryKey(1);
//	        user.setCity(city);
	        return user;
    }
}
