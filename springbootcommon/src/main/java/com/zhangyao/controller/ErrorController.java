package com.zhangyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyao.utils.IMoocJSONResult;

@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		
		int a = 1 / 0;
		
		return "/error";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public IMoocJSONResult getAjaxerror() {
		
		int a = 1 / 0;
		
		return IMoocJSONResult.ok();
	}
}