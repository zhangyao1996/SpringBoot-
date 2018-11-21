package com.zhangyao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangyao.entity.User;
import com.zhangyao.service.UserService;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 20, 2018 2:52:05 PM
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public String getUser(ModelMap map) {
		map.addAttribute("userList", userService.getAllUser());
		return "userList";
	}

	@GetMapping("/create")
	public String createUserForm(ModelMap map) {
		map.addAttribute("user", new User());
		map.addAttribute("action", "create");
		return "userForm";
	}

	/**
	 * 创建用户 处理 "/users" 的 POST 请求，用来获取用户列表 通过 @ModelAttribute 绑定参数，也通过 @RequestParam
	 * 从页面中传递参数
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postUser(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			map.addAttribute("action", "create");
			return "userForm";
		}

		userService.insertUser(user);

		return "redirect:/users/";
	}

	/*
	 * 删除用户
	 */
	@GetMapping("/delete/{userId}")
	public String deleteById(@PathVariable("userId") Integer id) {
		System.out.println("hhhhhhhhh");
		userService.deleteUser(id);
		return "redirect:/users/";

	}

	/*
	 * 更新用户
	 */
	@GetMapping("/update/{userId}")
	public String getUserForm(@PathVariable("userId") Integer id, ModelMap map) {
		map.addAttribute("user", userService.getUserById(id));
		map.addAttribute("action", "update");
		return "userForm";
	}

	@PostMapping("/update")
	public String updateUser(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			map.addAttribute("action", "update");
			return "userForm";
		}

		userService.updateUser(user);

		return "redirect:/users/";
	}

}
