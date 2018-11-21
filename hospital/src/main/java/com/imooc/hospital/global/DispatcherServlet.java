package com.imooc.hospital.global;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Servlet implementation class DispatchServlet
 */
public class DispatcherServlet extends GenericServlet {
	private ApplicationContext context;
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		/*
		 *  /user/add.do
		 *  /login.do
		 */
	/*	
		 String path = request.getServletPath().substring(1);
		 String beanName = null;
		 String methodName = null;
		 int index = path.indexOf("/");
		 if(index!=-1) {
			 beanName=path.substring(0,index)+"Controller";
			 System.out.println("beanName"+beanName);
			 methodName=path.substring(index+1,path.indexOf(".do"));
			 System.out.println("methodName"+methodName);
		 } else {
	            beanName = "selfController";
	            System.out.println(beanName);
	            methodName = path.substring(0, path.indexOf(".do"));
	     }*/
		 String path = request.getServletPath().substring(1);
	        String beanName = null;
	        String methodName = null;
	        int index = path.indexOf('/');
	        if (index != -1) {
	            beanName = path.substring(0, index) + "Controller";
	            System.out.println("beanName"+beanName);
	            methodName = path.substring(index + 1, path.indexOf(".do"));
	            } else {
	                beanName = "selfController";
	                methodName = path.substring(0, path.indexOf(".do"));
	            }
		 Object obj=context.getBean(beanName);
		 System.out.println("object"+obj);
		 try {
	            Method method = obj.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
	            method.invoke(obj,request,response);
	        } catch (NoSuchMethodException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	        }
        
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		context=new ClassPathXmlApplicationContext("spring.xml");
	}
	
}
