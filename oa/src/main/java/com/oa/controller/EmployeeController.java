package com.oa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.oa.entity.Employee;
import com.oa.global.Contant;
import com.oa.service.DepartmentService;
import com.oa.service.EmployeeService;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 27, 2018 3:48:21 PM
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/list")
	private String getAll(ModelMap map) {
		map.addAttribute("emps", employeeService.getAll());
		return "employee_list";
	}

	@RequestMapping("/to_add")
	private String toAddPage(ModelMap map) {
		map.addAttribute("dlist", departmentService.getAll());
		map.addAttribute("plist", Contant.getPosts());
		return "employee_add";
	}

	@RequestMapping("/add")
	@Transactional
	private String addEmp(Employee employee, ModelMap map) {
		int i = employeeService.addEmp(employee);
		System.out.println(i);
		if (i != 0) {
			System.out.println("添加成功");
			return "redirect:/employee/list";
		} else {
			map.addAttribute("msg", "添加失败，请重新添加");
			return "redirect:/employee/to_add";
		}

	}

	@RequestMapping("/remove")
	private String deleteEmp(String sn) {

		int i = employeeService.deleteEmp(sn);
		return "redirect:/employee/list";
	}
	
	
	@RequestMapping("/to_update")
	private String toUpdatePage(String sn,ModelMap map) {
		map.addAttribute("dlist", departmentService.getAll());
		map.addAttribute("plist", Contant.getPosts());
		map.addAttribute("emp", employeeService.getEmp(sn));
		return "employee_update";
	}
	
	@RequestMapping("/update")
	@Transactional
	private String updateEmp(Employee employee) {
		employeeService.updateEmp(employee);
		return "redirect:/employee/list";
	}

}
