package com.zhangyao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.User;
import com.zhangyao.mapper.UserMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 20, 2018 2:52:17 PM
*/
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public List<User> getAllUser(){
		return userMapper.selectAllUser();
	}
	
	public int insertUser(User user) {
		return userMapper.insert(user);
		
	}
	
	public int deleteUser(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}
	
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}
}
