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

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 10:19:42 AM
*/
@Controller("categoryController")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	//   /category/list.do
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*response.sendRedirect("../category_list.jsp");*/
		List<Category> lists1=categoryService.getAll();
		request.getSession().setAttribute("categorys", lists1);
		request.getRequestDispatcher("../category_list.jsp").forward(request, response);
   }
	
	//   category/addPrompt.do
	public void addPrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../category_add.jsp");
   }
	// 	/category/add.do
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		Category category=new Category();
		category.setName(name);
		categoryService.add(category);
		 List<Category> lists1=categoryService.getAll();
		 request.getSession().setAttribute("categorys", lists1);
		response.sendRedirect("list.do");
   }
	
	// 	/category/delete.do
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id=Integer.parseInt(request.getParameter("id"));
		categoryService.remove(id);
		 List<Category> lists1=categoryService.getAll();
	    	
    	 request.getSession().setAttribute("categorys", lists1);
		response.sendRedirect("list.do");
   }
	
	//   /category/updatePrompt.do
	public void updatePrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Category category=categoryService.getById(id);
		request.setAttribute("category", category);
		request.getRequestDispatcher("../category_update.jsp").forward(request, response);
   }
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Category category=categoryService.getById(id);
		category.setName(request.getParameter("name"));
		category.setUpdateTime(new Date());
		categoryService.edit(category);
		 List<Category> lists1=categoryService.getAll();
    	 request.getSession().setAttribute("categorys", lists1);
		response.sendRedirect("list.do");
		
   }
}
