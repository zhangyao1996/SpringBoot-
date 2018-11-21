package com.imooc.sm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 1:51:14 PM
*/
@Controller("departmentController")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	 //  /department/list.do     /department_list.jsp
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    }
    //跳转到添加页面
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request,response);
    }
    //部门数据添加
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name=request.getParameter("name");
    	String address=request.getParameter("address");
    	System.out.println(name);
    	Department department=new Department(name,address);
    	departmentService.add(department);
       // request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    	response.sendRedirect("list.do");
    }
    //部门数据删除
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	departmentService.remove(id);
        response.sendRedirect("list.do");
    }
    //跳转到编辑页面
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	Department department=departmentService.get(id);
    	request.setAttribute("OBJ", department);
        request.getRequestDispatcher("../department_edit.jsp").forward(request,response);
    }
    //修改部门数据
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	
    	String name=request.getParameter("name");
    	String address=request.getParameter("address");
    	Department department=new Department(id,name,address);
    	departmentService.edit(department);
        request.getRequestDispatcher("list.do").forward(request,response);
    }
}
