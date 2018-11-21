package com.imooc.shopmgr.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

	protected String encodingName="utf-8";   

    protected FilterConfig sysFilter;  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {     
			request.setCharacterEncoding(this.encodingName);   
			response.setContentType("text/html;charset=" + this.encodingName);   
			response.setCharacterEncoding(this.encodingName);   
			chain.doFilter(request, response);   
        } catch (Exception e) {   
        //....
        }  finally{
        	chain.doFilter(request, response);   
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.sysFilter = fConfig;   
        this.encodingName = this.sysFilter.getInitParameter("encoding");  
	}

}
