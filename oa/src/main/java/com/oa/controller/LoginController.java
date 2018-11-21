package com.oa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oa.entity.Employee;
import com.oa.service.EmployeeService;
import com.oa.service.GlobalService;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 28, 2018 10:24:44 AM
 */
@Controller
public class LoginController {
	@Autowired
	private GlobalService globalService;
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/self")
	public String login(@RequestParam(value="sn",required=false) String sn, @RequestParam(value="password",required=false) String password,HttpSession session) {
		Employee employee=globalService.login(sn, password);	
		if ( employee!= null) {
			session.setAttribute("emp", employee);
			System.out.println(employee);
			return "self";
		} else {
			return "redirect:/login";

		}
	}
	@RequestMapping("/myself")
	public String toSelf() {
		return "self";
	}
	
	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/to_change_password")
	public String toChangePasswordPage(){
		return "change_password";
	}
	
	@RequestMapping("/changePassword")
	@Transactional
	public String changePassword(HttpSession session,@RequestParam("old") String old,@RequestParam("new1") String new1,@RequestParam("new2") String new2) {
		Employee employee=(Employee) session.getAttribute("emp");
		System.out.println(employee);
		if(old.equals(employee.getPassword())&&new1.equals(new2)) {
			employee.setPassword(new2);
			
			employeeService.updateEmp(employee);
			
			session.setAttribute("emp", employee);
			System.out.println("修改成功");
			return "redirect:/myself";
		}else {
			System.out.println("修改失败");
			return "redirect:/to_change_password";
		}
	
	}
}
