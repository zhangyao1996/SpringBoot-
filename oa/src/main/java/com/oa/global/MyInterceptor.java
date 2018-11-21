package com.oa.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* @author zhangyao:
* @date 创建时间：Sep 28, 2018 11:06:13 AM
*/
public class MyInterceptor implements HandlerInterceptor {
	 Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        // TODO Auto-generated method stub
	        logger.info("------preHandle------");
	        //获取session
	        HttpSession session = request.getSession(true);
	        //判断用户ID是否存在，不存在就跳转到登录界面
	        if(session.getAttribute("emp") == null){
	            logger.info("------:跳转到login页面！");
	  response.sendRedirect(request.getContextPath()+"/login");
	            return false;
	        }else{
	        	System.out.println("通过拦截器");
	            session.setAttribute("emp", session.getAttribute("emp"));
	            return true;
	        }
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        // TODO Auto-generated method stub

	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        // TODO Auto-generated method stub

	    }

}
