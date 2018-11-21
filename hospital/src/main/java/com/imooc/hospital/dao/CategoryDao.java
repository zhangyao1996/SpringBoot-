package com.imooc.hospital.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.hospital.entity.Category;

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:28:04 AM
*/
@Repository("categoryDao")
public interface CategoryDao {
	public List<Category> selectAll();
	public void insert(Category category);
	public void deleteById(Integer id);
	public Category selectById(Integer id);
	public void update(Category category);
}
