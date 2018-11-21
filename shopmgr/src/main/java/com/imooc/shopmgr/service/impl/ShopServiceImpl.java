package com.imooc.shopmgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.shopmgr.entity.Article;
import com.imooc.shopmgr.entity.ArticleType;
import com.imooc.shopmgr.entity.User;
import com.imooc.shopmgr.mapper.ArticleMapper;
import com.imooc.shopmgr.mapper.ArticleTypeMapper;
import com.imooc.shopmgr.mapper.UserMapper;
import com.imooc.shopmgr.utils.Pager;

/**
* @author zhangyao:
* @date 创建时间：Aug 31, 2018 5:07:40 PM
*/
@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ArticleMapper articleMapper;
	
	public List<ArticleType> getAllArticleType() {
		// TODO Auto-generated method stub
		return articleTypeMapper.selectAll();
	}

	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean login(String userName,String passWord) {
		// TODO Auto-generated method stub
		User user=userMapper.login(userName);
		if(user==null) {
			return false;
		}else if(user !=null &&user.getPassword().equals(passWord)){
			return true;
		}
		return false;
	}

	public List<ArticleType> getFirst() {
		// TODO Auto-generated method stub
		return articleTypeMapper.selectFirst();
	}

	public List<Article> getAllArticle(String typeCode,String secondType ,String title,Pager pager) {
		// TODO Auto-generated method stub
		// 界面需要当前总共有多少条数据
        // 查询当前条件下总共有多少条数据
        int count = articleMapper.count(typeCode , secondType ,title);
        pager.setTotalCount(count);
		return articleMapper.selectAll(typeCode,secondType,title,pager);
	}

	public List<ArticleType> getSecond(String typeCode) {
		// TODO Auto-generated method stub
		return articleTypeMapper.selectSecond(typeCode+"%",typeCode.length()+4);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("remove");
		articleMapper.deleteById(id);
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectById(id);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleMapper.update(article);
	}

}
