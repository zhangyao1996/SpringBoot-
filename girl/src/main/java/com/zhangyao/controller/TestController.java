package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 10:21:20 AM
*/
@Controller
public class TestController {
	
	
	@RequestMapping("/hello/{id}")
	@ResponseBody
	public String helloWorld(@PathVariable("id") Integer id) {
		return "id"+id;
	}
	
	@RequestMapping("/hello1")
	@ResponseBody
	public String helloWorld1(@RequestParam(value="id" ,required=false, defaultValue="0") Integer id) {
		return "id"+id;
	}
	
	@GetMapping("/hello2")
	@ResponseBody
	public String helloWorld2(@RequestParam(value="id" ,required=false, defaultValue="0") Integer id) {
		return "id"+id;
	}
	
	@RequestMapping({"/hi","hi1"})
	
	public String hi() {
		return "index";
	}

}
