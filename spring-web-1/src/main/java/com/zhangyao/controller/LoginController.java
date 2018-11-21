package com.zhangyao.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author zhangyao:
* @date 创建时间：Sep 26, 2018 9:11:15 AM
*/
@Controller
public class LoginController {
	
	/*@RequestMapping("/success")
	private String success(ModelMap map) {
		map.addAttribute("name", "张三");
		map.addAttribute("users", Arrays.asList("英语","数学","语文"));
		return "success";
	}*/
	
	@RequestMapping("/login")
	private String gotoDashboard(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap map,HttpSession session) {
		if(username!=null&&password.equals("123456")) {
			session.setAttribute("loginUser", username);
			return "dashboard";
		}else {
			map.addAttribute("msg", "用户名或者密码错误");
			return "index";
		}
		
	}
	
//	@PostMapping("/emp")
//	public String addEmp() {
//		
//	}
	

}
