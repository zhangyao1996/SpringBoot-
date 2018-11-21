package com.imooc.hospital.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.hospital.entity.Users;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 4:35:18 PM
*/
@Repository("usersDao")
public interface UsersDao {
	void insert(Users user);
	void deleteById(Integer id);
	void update(Users user);
	Users selectByUsername(String username);
	List<Users> selectAll();
}
