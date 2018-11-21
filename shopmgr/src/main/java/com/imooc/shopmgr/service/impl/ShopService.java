package com.imooc.shopmgr.service.impl;
/**
* @author zhangyao:
* @date 创建时间：Aug 31, 2018 5:07:15 PM
*/

import java.util.List;

import com.imooc.shopmgr.entity.Article;
import com.imooc.shopmgr.entity.ArticleType;
import com.imooc.shopmgr.entity.User;
import com.imooc.shopmgr.utils.Pager;

public interface ShopService {

	public List<ArticleType> getAllArticleType();
	
	public boolean login(String userName,String passWord);
	
	public User getUser(String userName);
	
	public List<ArticleType> getFirst();
	
	public List<Article> getAllArticle(String typeCode, String secondType, String title, Pager pager);

	public List<ArticleType> getSecond(String typeCode);
	
	public void remove(Integer id);
	
	public Article getById(Integer id);

	public void updateArticle(Article article);
}
