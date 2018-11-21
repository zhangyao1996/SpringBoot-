package com.imooc.hospital.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.hospital.entity.Category;
import com.imooc.hospital.entity.Dept;
import com.imooc.hospital.service.CategoryService;
import com.imooc.hospital.service.DeptService;

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 2:06:35 PM
*/
@Controller("deptController")
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private CategoryService categoryService;
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("这是list");
		/*response.sendRedirect("../category_list.jsp");*/
		/*String path=request.getServletPath();
		System.out.println(path);
		System.out.println(request.getParameter("categoryId"));*/
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		List<Dept> depts=deptService.getByCategoryId(categoryId);
		request.setAttribute("deptByCategoryId", depts);
		request.getRequestDispatcher("../dept_list.jsp").forward(request, response);
   }
	public void addPrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../dept_add.jsp");
   }
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("name"+name);
		System.out.println("categoryId"+categoryId);
		Dept dept=new Dept();
		dept.setCategoryId(categoryId);
		dept.setName(name);
	/*	dept.setCreateTime(new Date());
		dept.setUpdateTime(new Date());*/
		deptService.add(dept);
		
		List<Dept> depts=deptService.getByCategoryId(categoryId);
		request.setAttribute("deptByCategoryId", depts);
		request.getRequestDispatcher("../dept_list.jsp").forward(request, response);
   }
	
	//  dept/delete.do
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println("deleteid"+id);
		Integer categoryId=null;
		Dept dept=deptService.getById(id);
		categoryId=dept.getCategoryId();
		System.out.println(dept);
/*		Dept dept=deptService.getById(id);
		Integer categoryId=dept.getCategoryId();
		System.out.println("name:"+dept.getName());
		System.out.println("deletecateid"+dept.getCategoryId());*/
		deptService.remove(id);
		List<Dept> depts=deptService.getByCategoryId(categoryId);
		request.setAttribute("deptByCategoryId", depts);
		request.getRequestDispatcher("../dept_list.jsp").forward(request, response);
   }
	public void updatePrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Dept dept=deptService.getById(id);
		List<Category> lists=categoryService.getAll();
		request.setAttribute("dept", dept);
		request.setAttribute("categorys", lists);
		request.getRequestDispatcher("../dept_update.jsp").forward(request, response);
   }
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("name"+name);
		System.out.println("categoryId"+categoryId);
		Dept dept=new Dept();
		dept.setCategoryId(categoryId);
		dept.setName(name);
		dept.setId(id);
		deptService.edit(dept);
		List<Dept> depts=deptService.getByCategoryId(categoryId);
		request.setAttribute("deptByCategoryId", depts);
		request.getRequestDispatcher("../dept_list.jsp").forward(request, response);
		
   }
}
