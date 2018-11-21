package com.imooc.shopmgr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.shopmgr.service.impl.ShopService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 4:33:22 PM
*/
@Controller("selfController")
public final class SelfController {
	
	@Autowired
	private ShopService shopService;
	// /toLogin.do
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("toLogin.do");
		request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
   }
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
   }
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login.do");
		String loginName=request.getParameter("loginName");
		String passWord=request.getParameter("passWord");
		System.out.println("loginName"+loginName);
		System.out.println("password"+passWord);
		boolean result = shopService.login(loginName,passWord);
		if(result) {
			response.sendRedirect("list/list.do?method=getAll");
			//request.getRequestDispatcher("jsp/list.jsp").forward(request,response);
		}else {
			request.setAttribute("MSG", "用户名或者密码错误");
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			System.out.println("用户名或者密码错误");
		}
		
		
   }
	
	
}
