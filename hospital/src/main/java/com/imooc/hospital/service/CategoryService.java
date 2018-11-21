package com.imooc.hospital.service;
/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:33:38 AM
*/

import java.util.List;

import com.imooc.hospital.entity.Category;

public interface CategoryService {
	public List<Category> getAll();
	public void add(Category category);
	public void remove(Integer id);
	public Category getById(Integer id);
	public void edit(Category category);
}
