package com.oa.global;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author zhangyao:
* @date 创建时间：Sep 7, 2018 11:05:13 AM
*/
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
	
	private String encoding="utf-8";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		if(filterConfig.getInitParameter("encoding")!=null) {
			encoding=filterConfig.getInitParameter("encoding");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		request2.setCharacterEncoding(encoding);
		response2.setCharacterEncoding(encoding);
		chain.doFilter(request2, response2);
		//System.out.println("helofilte");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
