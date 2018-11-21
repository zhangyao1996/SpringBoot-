package com.zhangyao.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.User;
import com.zhangyao.utils.IMoocJSONResult;

/**
* @author zhangyao:
* @date 创建时间：Sep 12, 2018 11:03:23 AM
*/
@RestController
public class UserController {
	@RequestMapping("/getuser")
	private IMoocJSONResult getUser() {
		User user=new User();
		user.setAge(28);
		user.setName("张三");
		user.setPassword("imooc1");
		user.setBirthday(new Date());
		return IMoocJSONResult.ok(user);
	}
}
