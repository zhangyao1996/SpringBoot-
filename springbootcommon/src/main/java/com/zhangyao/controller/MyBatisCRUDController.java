package com.zhangyao.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.utils.IMoocJSONResult;
import com.zhangyao.entity.SysUser;
import com.zhangyao.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011003");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		//return IMoocJSONResult.ok("保存成功");
		return IMoocJSONResult.ok(user);
	}
	
	@RequestMapping("/deleteUser/{id}")
	public IMoocJSONResult deleteUser(@PathVariable("id") String userId) {
		
		userService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById/{id}")
	public IMoocJSONResult queryUserById(@PathVariable("id") String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	
	//分页查询
	@RequestMapping("/queryUserListPaged")
	public IMoocJSONResult queryUserListPaged(Integer page) {
		//page为当前页数
		if (page == null) {
			page = 1;
		}
		//该页所拥有数据
		int pageSize = 3;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public IMoocJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
}
