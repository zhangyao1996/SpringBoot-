package com.zhangyao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.User;
import com.zhangyao.mapper.UserMapper;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 3:37:03 PM
*/
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	

	public List<User> getAllUser() {
		return userMapper.getAll();
		
	}
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
}
