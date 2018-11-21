package com.imooc.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.hospital.entity.Category;
import com.imooc.hospital.entity.Dept;
import com.imooc.hospital.entity.Users;
import com.imooc.hospital.service.CategoryService;
import com.imooc.hospital.service.DeptService;
import com.imooc.hospital.service.UsersService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 4:33:22 PM
*/
@Controller("selfController")
public final class SelfController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private DeptService deptService;
	// /toLogin.do
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("login.jsp").forward(request,response);
   }
	//self/login.do
	 public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     System.out.println("这是login");  
	     String username=request.getParameter("username");
	     String password=request.getParameter("password");
	     System.out.println(username);
	     Users user=usersService.login(username, password);
	     if(user!=null) {
	    	 List<Category> lists1=categoryService.getAll();
	    	 List<Dept> lists2=deptService.getAll();
	    	 request.getSession().setAttribute("categorys", lists1);
	    	 request.getSession().setAttribute("depts", lists2);
	    	 //System.out.println(lists1);
	    	// request.setAttribute("depts", lists2);
	    	 request.getSession().setAttribute("username", username);
	    	 request.getRequestDispatcher("category.jsp").forward(request,response);
	     }
	     else {
	    	request.setAttribute("msg", "账号或者密码错误");
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
		
			
		}
    }
}
