package com.imooc.sm.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.StaffService;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 4:54:10 PM
*/
@Controller("staffController")
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private DepartmentService departmentService;
	//查看所有用户
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staffs=staffService.getAll();
        request.setAttribute("LIST", staffs);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }
	//增加用户界面
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments=departmentService.getAll();
        request.setAttribute("DLIST", departments);
		request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }
	//增加用户
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String account=request.getParameter("account");
       Integer did=Integer.parseInt(request.getParameter("did"));
       String name=request.getParameter("name");
       String sex=request.getParameter("sex");
       String idNumber=request.getParameter("idNumber");
       Date bornDate=null;
       try {
		bornDate=new SimpleDateFormat("YYYY-MM-DD").parse(request.getParameter("bornDate"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String info=request.getParameter("info");
       Staff staff=new Staff();
       staff.setAccount(account);
       staff.setDid(did);
       staff.setName(name);
       staff.setSex(sex);
       staff.setIdNumber(idNumber);
       staff.setBornDate(bornDate);
       staff.setInfo(info);
       staffService.add(staff);
      response.sendRedirect("list.do");
    }
	//跳转到编辑员工页面
	public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Integer id=Integer.parseInt(request.getParameter("id"));
     List<Department> departments=departmentService.getAll();
     request.setAttribute("DLIST", departments);
     Staff staff=staffService.getById(id);
     System.out.println("身份证号："+ staff.getIdNumber());
     request.setAttribute("OBJ", staff);
     request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }
	//修改员工信息
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Integer id=Integer.parseInt(request.getParameter("id"));
		   Staff staff1=staffService.getById(id);
		   String account=request.getParameter("account");
		   String password=request.getParameter("password");
		   String status=request.getParameter("status");
	       Integer did=Integer.parseInt(request.getParameter("did"));
	       String name=request.getParameter("name");
	       String sex=request.getParameter("sex");
	       String idNumber=request.getParameter("idNumber");
	       Date bornDate=null;
	       try {
			bornDate=new SimpleDateFormat("YYYY-MM-DD").parse(request.getParameter("bornDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       Date leaveTime=null;
	       try {
	    	   leaveTime=new SimpleDateFormat("YYYY-MM-DD").parse(request.getParameter("leaveTime"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	       String info=request.getParameter("info");
	       Staff staff=new Staff();
	       staff.setId(id);
	       staff.setAccount(account);
	       staff.setPassword(password);
	       staff.setStatus(status);
	       staff.setWorkTime(staff1.getWorkTime());
	       staff.setLeaveTime(leaveTime);
	       staff.setDid(did);
	       staff.setName(name);
	       staff.setSex(sex);
	       staff.setIdNumber(idNumber);
	       staff.setBornDate(bornDate);
	       staff.setInfo(info);
	       staffService.edit(staff);
	       response.sendRedirect("list.do");
    }
	//删除员工
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		staffService.remove(id);
		response.sendRedirect("list.do");
    }
	//查看员工信息
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Staff staff=staffService.getById(id);
		request.setAttribute("OBJ", staff);
		request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }
}
