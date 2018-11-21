package com.imooc.hospital.service;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 4:51:07 PM
*/

import com.imooc.hospital.entity.Users;

public interface UsersService {
	public  Users  login(String username,String password);
}
