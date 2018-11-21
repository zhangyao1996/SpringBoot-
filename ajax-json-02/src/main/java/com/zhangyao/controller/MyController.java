package com.zhangyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author zhangyao:
* @date 创建时间：Oct 8, 2018 2:03:40 PM
*/
@Controller
public class MyController {

	@RequestMapping("/checkUserName")
	private String gotoCheckUserName() {
		return "checkUserName";
	}
	
	@RequestMapping("/ejld")
	private String gotoEjid() {
		return "ejld";
	}
}
