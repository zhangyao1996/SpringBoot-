package com.imooc.shopmgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.imooc.shopmgr.entity.Article;
import com.imooc.shopmgr.utils.Pager;

/**
 * ArticleMapper 数据访问类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-08-31 16:16:31
 * @version 1.0
 */

public interface ArticleMapper {	
	public List<Article> selectAll(@Param("typeCode")String typeCode, @Param("secondType")String secondType,@Param("title")String title,@Param("pager")Pager pager);
	
	int count(@Param("typeCode") String typeCode ,
            @Param("secondType") String secondType , @Param("title") String title);
	
	public void deleteById(@Param("id")Integer id);
		
	public Article selectById(@Param("id")Integer id);
	
	void update(Article article);
	
}