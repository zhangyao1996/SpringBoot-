package com.imooc.shopmgr.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.imooc.shopmgr.entity.ArticleType;
import com.imooc.shopmgr.service.impl.ShopService;

/**
 * Servlet implementation class ArticleTypeServlet
 */
public class ArticleTypeServlet extends HttpServlet {
	@Autowired
	private ShopService shopService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		 // 获取sping的容器。然后从容器中得到业务层对象
        ServletContext servletContext = this.getServletContext() ;
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService) context.getBean("shopService");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ArticleType> list=shopService.getAllArticleType();
		for (ArticleType articleType : list) {
			System.out.println(articleType);
		}
	}

}
