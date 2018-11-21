package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.User;

import com.zhangyao.service.UserService;

/**
* @author zhangyao:
* @date 创建时间：Sep 19, 2018 4:08:36 PM
*/
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	
	@GetMapping("get/{id}")
	public User get( @PathVariable("id") Integer id) {
		return userService.findById(id);
	}

}
