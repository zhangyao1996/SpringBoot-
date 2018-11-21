package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangyao.entity.Employee;
import com.zhangyao.service.EmployeeService;

/**
* @author zhangyao:
* @date 创建时间：Sep 26, 2018 3:40:42 PM
*/
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/emplist")
	public String getEmpLists(ModelMap map) {
		System.out.println(employeeService.getAllEmps());
		map.addAttribute("lists", employeeService.getAllEmps());
		return "emp/list";
	}
	
	@GetMapping("/addpage")
	public String toAddPage() {
		return "/emp/add";
	}
	
	@RequestMapping("/emp")
	@Transactional
	public String addEmp(Employee emp,BindingResult bindingResult) {
		System.out.println(emp);
		//emp.setId(2);
		int i=employeeService.addEmp(emp);
		if(i!=0) {
			System.out.println("添加成功");
		}
		//重定向
		return "redirect:emplist";
	}
}
