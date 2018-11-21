package com.imooc.sm.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import com.imooc.sm.service.StaffService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 10:37:49 AM
*/
@Controller("selfController")
public class SelfController {
	@Autowired
	private SelfService selfService;
	// toLogin.do
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	// login.do
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		Staff staff=selfService.login(account, password);
		if(staff!=null) {
			request.getSession().setAttribute("USER", staff);
			response.sendRedirect("main.do");
		}else {
			response.sendRedirect("toLogin.do");
		}
		
	}
	// main.do
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	// logout.do
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().setAttribute("USER",null);
		response.sendRedirect("toLogin.do");
	}
	// self/info.do
	public void info(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("这是INFO()");
		request.getRequestDispatcher("../info.jsp").forward(request,response);
	}
	// self/toChangePassword.do
	public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("../change_password.jsp").forward(request, response);
	}
	// changePassword.do
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		Staff staff=(Staff) request.getSession().getAttribute("USER");
		if(!password.equals(staff.getPassword())) {
			response.sendRedirect("toChangePassword.do");
		}else {
			int id=staff.getId();
			selfService.changePassword(id, password1);
			//response.sendRedirect("../logout.do");
			 response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
		}
	}
}
