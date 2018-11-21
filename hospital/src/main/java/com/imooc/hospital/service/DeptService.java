package com.imooc.hospital.service;
/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:50:41 AM
*/

import java.util.List;

import com.imooc.hospital.entity.Dept;

public interface DeptService {
	public List<Dept> getAll();
	public List<Dept> getByCategoryId(Integer categoryId);
	public void add(Dept dept);
	public Dept getById(Integer id);
	public void remove(Integer id);
	public void edit(Dept dept);
}
