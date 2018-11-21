package com.zhangyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author zhangyao:
* @date 创建时间：Sep 30, 2018 3:47:45 PM
*/
@Controller
public class HelloController {

	@RequestMapping("/hello")
	private String toHelloPage() {
		return "layui/hello";
	}
	
	@RequestMapping("/layout")
	private String toLayoutPage() {
		return "layui/layout";
	}
}
