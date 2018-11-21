package com.zhangyao.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author zhangyao:
* @date 创建时间：Oct 16, 2018 10:07:37 AM
*/
/*
 * 异步非阻塞
 */
@WebServlet(urlPatterns="/my/servlet",asyncSupported=true)
public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AsyncContext asyncContext=req.startAsync();
		asyncContext.start(()->{
			try {
				resp.getWriter().println("hello world");
				//触发完成
				asyncContext.complete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	

}
