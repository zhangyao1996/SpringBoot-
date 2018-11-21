package com.zhangyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author zhangyao:
* @date 创建时间：Oct 8, 2018 9:29:52 AM
*/
@Controller
public class AjaxController {
	@RequestMapping("/ajax")
	private String gotoAjax() {
		return "ajax";
	}
	@RequestMapping("/ajaxServlet1")
	
	private String gotoajax() {
		System.out.println("hhhhhhh");
		return "ajax";
	}
}
