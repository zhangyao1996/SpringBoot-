package com.imooc.shopmgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.imooc.shopmgr.entity.ArticleType;

/**
 * ArticleTypeMapper 数据访问类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-08-31 16:16:31
 * @version 1.0
 */
public interface ArticleTypeMapper {
	@Select("select * from ec_article_type where length(CODE)=4")
	public List<ArticleType> selectFirst();
	
	@Select("select * from ec_article_type")
	public List<ArticleType> selectAll();

	@Select("select * from ec_article_type where CODE like #{typeCode} and length(CODE)=#{i}")
	public List<ArticleType> selectSecond(@Param("typeCode")String typeCode,@Param("i") int i);
	
	@Select("select * from ec_article_type where CODE=#{code}")
	public ArticleType getTypeByCode(@Param("code")String typeCode);
}
