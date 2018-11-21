package com.imooc.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.hospital.dao.UsersDao;
import com.imooc.hospital.entity.Users;
import com.imooc.hospital.service.UsersService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 4:52:12 PM
*/
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		Users user=usersDao.selectByUsername(username);
		if (user==null) {
			return null;
		}
		if (password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

}
