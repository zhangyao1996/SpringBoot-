package com.imooc.sm.global;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 */
/*@WebFilter(filterName="Encoding",
urlPatterns="/*",
initParams=@WebInitParam(name="ENCODING",value="utf-8")
)*/
public class EncodingFilter implements Filter {

	 private String encoding ="UTF-8";

	    public void init(FilterConfig filterConfig) throws ServletException {
	        if(filterConfig.getInitParameter("ENCODING")!=null)
	            encoding = filterConfig.getInitParameter("ENCODING");
	    }

	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	        servletRequest.setCharacterEncoding(encoding);
	        servletResponse.setCharacterEncoding(encoding);
	        filterChain.doFilter(servletRequest,servletResponse);
	        System.out.println("处理中文乱码");
	    }

	    public void destroy() {
	        encoding=null;
	    }


}
