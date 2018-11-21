package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.component.MyComponent;

/**
* @author zhangyao:
* @date 创建时间：Sep 5, 2018 4:44:04 PM
*/

@Controller
public class MyController {
	@Autowired
	private MyComponent myComponent;
	
	@RequestMapping("/")
//	@ResponseBody
	public String out() {
		
		//myComponent.fun();
		return "home";
	}
}
