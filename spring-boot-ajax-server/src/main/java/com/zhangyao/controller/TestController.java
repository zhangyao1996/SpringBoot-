package com.zhangyao.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyao.entity.ResultBean;
import com.zhangyao.entity.User;
import com.zhangyao.service.UserService;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 2:40:02 PM
*/
@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/get1")
	@ResponseBody
	private ResultBean get1() {
		return new ResultBean("hello");
	}
	
	@GetMapping("/index")
	private String getIndex(ModelMap map) {
		List<User> users=userService.getAllUser();
		map.addAttribute("users", users);
		return "index";
	}
	@GetMapping("/find")
	private String getUser(@RequestParam("id") Integer id,ModelMap map) {
		User user=userService.getUserById(id);
		map.addAttribute("user", user);
		return "user";
	}
	
	@GetMapping("/{id}")
	private String getUser2(@PathVariable Integer id,ModelMap map) {
		User user=userService.getUserById(id);
		map.addAttribute("user", user);
		return "user";
	}
	
	@GetMapping("/getUsers")
	@ResponseBody
	private List<User> getUsers() {
		
		return userService.getAllUser();
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
	    //return "<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1><p>This is my first web site</p></body></html>";
		return "hello"; 
	}
	
    @RequestMapping("/create")
 
    public String create() {
        return "redirect:/test/index";
    }
    @GetMapping("/blog")
    @ResponseBody
    public String blog() {
        return "<html><head><title>Title</title></head><body><h2>This is a blog</h2><p>This is content of the blog.</p></body></html>";
    }
}
