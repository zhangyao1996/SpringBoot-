package com.imooc.sm.global;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//登录过滤器
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		 HttpServletRequest request=(HttpServletRequest)servletRequest;
	        HttpServletResponse response = (HttpServletResponse)servletResponse;

	        String path = request.getServletPath();
	        System.out.println("path:"+path);
	        if(path.toLowerCase().indexOf("login")!=-1){
	            filterChain.doFilter(request,response);
	        }else{
	            HttpSession session = request.getSession();
	            Object obj =session.getAttribute("USER");
	            if(obj!=null){
	                filterChain.doFilter(request,response);
	            }else{
	                response.sendRedirect(request.getContextPath()+"/toLogin.do");
	            }
	        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
