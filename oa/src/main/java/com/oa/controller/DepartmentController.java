package com.oa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oa.entity.Department;
import com.oa.service.DepartmentService;

/**
* @author zhangyao:
* @date 创建时间：Sep 7, 2018 3:11:45 PM
*/
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		map.addAttribute("list", departmentService.getAll());
		System.out.println(departmentService.getAll());
		return "department_list";
	}
	
	
	@RequestMapping("/to_add")
	public String toAddPage() {
		return "department_add";
	}
	
	@RequestMapping("/add")
	@Transactional
	public String addDept(Department dept) {
		departmentService.addDept(dept);
		System.out.println("添加成功");
		return "redirect:/department/list";
	}
	
	@RequestMapping("/to_update")
	public String toUpdatePage(String sn,ModelMap map) {
		map.addAttribute("dept", departmentService.getDept(sn));
		return "department_update";
	}
	
	@RequestMapping("/update")
	@Transactional
	public String updateDept(Department dept) {
		departmentService.updateDept(dept);
		System.out.println("更新成功");
		return "redirect:/department/list";
	}
	
	@RequestMapping("/remove")
	@Transactional
	public String deleteDept(@RequestParam("sn") String sn) {
		departmentService.deleteDept(sn);
		return "redirect:/department/list";
	}
	
	
	
	@RequestMapping("/bottom")
	public String bottom() {
		
		return "commons/bottom";
	}
	@RequestMapping("/top")
	public String top() {
		
		return "commons/top";
	}
}
