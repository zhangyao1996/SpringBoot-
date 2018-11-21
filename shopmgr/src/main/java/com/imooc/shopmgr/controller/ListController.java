package com.imooc.shopmgr.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.shopmgr.entity.Article;
import com.imooc.shopmgr.entity.ArticleType;
import com.imooc.shopmgr.service.impl.ShopService;
import com.imooc.shopmgr.utils.Pager;

/**
* @author zhangyao:
* @date 创建时间：Sep 4, 2018 11:09:52 AM
*/
@Controller("listController")
public class ListController {
	@Autowired
	private ShopService shopService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request;
		this.response=response;
		
		String method=request.getParameter("method");
		switch (method) {
		case "getAll":
			getAll();
			break;
		case "deleteById":
			deleteById();
			break;
		case "preArticle":
			preArticle();
			break;
		case "showUpdate":
			showUpdate();
			break;
		case "updateArticle":
			updateArticle();
		default:
			break;
		}
	
		
		
   }
	public void getAll() throws ServletException, IOException {
		// 考虑分页查询
        Pager pager = new Pager();
        // 看是否传入了分页参数的页码
        String pageIndex = request.getParameter("pageIndex");
        if(!StringUtils.isEmpty(pageIndex)){
                int pSize = Integer.valueOf(pageIndex);
                pager.setPageIndex(pSize);
        }
		//接收一级类型
		String typeCode=request.getParameter("typeCode");
		//接收二级类型
		String secondType=request.getParameter("secondType");
		//接收标题
		String title =request.getParameter("title");
		request.setAttribute("title", title);
		request.setAttribute("secondType", secondType);
		if(typeCode!=null) {
			//根据一级类型查询二级类型
			List<ArticleType> secondArticleTypes=shopService.getSecond(typeCode);
			request.setAttribute("secondTypes", secondArticleTypes);
			request.setAttribute("typeCode",typeCode);
		}
		//查询一级类型数据
		List<ArticleType> firstArticleTypes=shopService.getFirst();
		//查询商品
		List<Article> articles=shopService.getAllArticle(typeCode,secondType,title,pager);
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		request.setAttribute("articles", articles);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("../jsp/list.jsp").forward(request, response);
	}
	
	//删除商品
	public void deleteById() throws ServletException, IOException {
		// 考虑分页查询
        Pager pager = new Pager();
        // 看是否传入了分页参数的页码
        String pageIndex = request.getParameter("pageIndex");
        if(!StringUtils.isEmpty(pageIndex)){
                int pSize = Integer.valueOf(pageIndex);
                pager.setPageIndex(pSize);
        }
		//接收id
		int id=Integer.parseInt(request.getParameter("id"));
		//接收一级类型
		String typeCode=request.getParameter("typeCode");
		//接收二级类型
		String secondType=request.getParameter("secondType");
		//接收标题
		String title =request.getParameter("title");
		request.setAttribute("title", title);
		request.setAttribute("secondType", secondType);
		if(typeCode!=null) {
			//根据一级类型查询二级类型
			List<ArticleType> secondArticleTypes=shopService.getSecond(typeCode);
			request.setAttribute("secondTypes", secondArticleTypes);
			request.setAttribute("typeCode",typeCode);
		}
		shopService.remove(id);
		//查询一级类型数据
		List<Article> articles=shopService.getAllArticle(typeCode,secondType,title,pager);
		List<ArticleType> firstArticleTypes=shopService.getFirst();
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		request.setAttribute("articles", articles);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("../jsp/list.jsp").forward(request, response);
		
	}
	//预览商品
	public void preArticle() throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		//查询商品
		Article article=shopService.getById(id);
		if(article!=null) {
			request.setAttribute("article", article);
		}
		request.getRequestDispatcher("../jsp/preArticle.jsp").forward(request, response);
		
	}
	
	
	public void showUpdate() throws ServletException, IOException {
		//接收id
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("update");
		
		List<ArticleType> types=shopService.getAllArticleType();
		request.setAttribute("types", types);
		//查询商品
		Article article=shopService.getById(id);
		if(article!=null) {
			request.setAttribute("article", article);
		}
	
		request.getRequestDispatcher("../jsp/updateArticle.jsp").forward(request, response);
	}
	
	//修改商品
	public void updateArticle() throws ServletException, IOException {
		 // 接收界面提交的参数
        // 获取请求参数 ----普通表单元素
        String code = request.getParameter("code");
        String title = request.getParameter("titleStr");
        String supplier = request.getParameter("supplier");
        String locality = request.getParameter("locality");
        String price = request.getParameter("price");
        String storage = request.getParameter("storage");
        String description = request.getParameter("description");
        String id = request.getParameter("id"); // 物品编号
        String picUrl = request.getParameter("picUrl"); // 物品旧封面
        // 定义一个商品对象封装界面提交的参数
        Article article = new Article();

        // 接收用户可能上传的封面
        String newUrl = receiveImage();
        picUrl = newUrl!=null ?newUrl:picUrl ;

        article.setId(Integer.valueOf(id));
        article.setImage(picUrl);
        ArticleType type = new ArticleType();
        type.setCode(code);
        article.setArticleType(type);
        article.setTitle(title);
        article.setSupplier(supplier);
        article.setLocality(locality);
        article.setPrice(Double.parseDouble(price));
        article.setStorage(Integer.parseInt(storage));
        article.setDescription(description);
        shopService.updateArticle(article);
        request.setAttribute("tip","修改商品成功");
        showUpdate();
	}
	
	 private String receiveImage() {
	        try{
	            // 如果用户上传了这里代码是不会出现异常 了
	            // 如果没有上传这里出现异常
	            Part part = request.getPart("image");
	            // 保存到项目的路径中去
	            String sysPath = request.getSession().getServletContext().getRealPath("/resources/images/article");
	            // 定义一个新的图片名称
	            String fileName = UUID.randomUUID().toString() ;
	            //  提取图片的类型
	            // 上传文件的内容性质
	            String contentDispostion = part.getHeader("content-disposition");
	            // 获取上传文件的后缀名
	            String suffix = contentDispostion.substring(contentDispostion.lastIndexOf("."), contentDispostion.length() - 1);
	            fileName+=suffix ;
	            // 把图片保存到路径中去
	            part.write(sysPath+"/"+fileName);
	            return fileName ;
	        }catch (Exception e){
	            e.printStackTrace();
	            return null ;
	        }
	    }
}
