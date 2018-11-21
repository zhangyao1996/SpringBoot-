package com.imooc.hospital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.hospital.dao.CategoryDao;
import com.imooc.hospital.entity.Category;
import com.imooc.hospital.service.CategoryService;

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:34:23 AM
*/
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.selectAll();
	}
	public void add(Category category) {
		// TODO Auto-generated method stub
		category.setCreateTime(new Date());
		categoryDao.insert(category);
	}
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		categoryDao.deleteById(id);
	}
	public Category getById(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.selectById(id);
	}
	public void edit(Category category) {
		// TODO Auto-generated method stub
			categoryDao.update(category);
	}


}
