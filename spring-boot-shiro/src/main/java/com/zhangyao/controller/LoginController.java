package com.zhangyao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyao.entity.User;

/**
 * @author zhangyao:
 * @date 创建时间：Oct 17, 2018 11:11:11 AM
 */
@Controller
public class LoginController {
	@PostMapping("/Login")
	@ResponseBody
	private String Login(User user) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		// 进行验证，这里可以捕获异常，然后返回对应信息
		subject.login(usernamePasswordToken);
		return "登陆成功";
	}

	@GetMapping("/toLogin")
	private String toLogin() {
		return "login";
	}
}
